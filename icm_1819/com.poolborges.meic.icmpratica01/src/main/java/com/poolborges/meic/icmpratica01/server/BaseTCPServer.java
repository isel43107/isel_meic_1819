/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmpratica01.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pauloborges
 */
public abstract class BaseTCPServer implements ServerAPI {

    private final static Logger LOG = Logger.getLogger(BaseTCPServer.class.getName());

    private final static int TIMEOUT = 4000;
    private ServerSocket serverSocket;
    private final int port;
    private boolean isAlive = true;

    private final AtomicBoolean exitAtomic = new AtomicBoolean(false);

    private final ScheduledExecutorService cleanupExecutorService = Executors.newSingleThreadScheduledExecutor();

    //Socket[addr=/127.0.0.1,port=57593,localport=9002]
    ConcurrentHashMap<String, Client> clients = new ConcurrentHashMap<>();

    public BaseTCPServer(int port) {
        this.port = port;
    }

    @Override
    public void start() {

        try {
            serverSocket.setSoTimeout(2000);
        } catch (SocketException ex) {
            LOG.log(Level.SEVERE, "Erro ao configurar timeout", ex);
        }

        while (isAlive()) {
            try {
                Socket newSock = serverSocket.accept();
                onClientConnection(newSock);
                addClient(newSock);
            } catch (java.net.SocketTimeoutException ex) {
                // OMITIR - ESPERO QUE ACONTEÇA TIMEOUT VAI CONTINUAR 
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, "Execption on accept new connection:", ex);
            }
        }

        System.out.println("Servidor nao aceita mais ligaçoes. Numero clientes ligados: " + clients.size());

        //waitForClientSocketClose();
        stop();
    }

    @Override
    public void stop() {
        try {
            System.out.println("Close server socket: " + serverSocket.toString());
            if (serverSocket != null) {
                serverSocket.close();
            }
            System.err.println("STOP FORCE - VERY STUPID");
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    protected void processSocket(final Socket socket) {

        if (socket == null) {
            LOG.log(Level.SEVERE, "Cannot process socket is null");
            return;
        }

        try {
            socket.setSoTimeout(15000);
        } catch (SocketException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

        System.out.println("BEGIN client: " + socket.toString()
                + ", with thread: " + Thread.currentThread());

        try (BufferedReader is
                = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter os = new PrintWriter(socket.getOutputStream(), true)) {
            while (!socket.isClosed()) {
                try {
                    String inputLine = is.readLine();
                    if (inputLine != null && !inputLine.isEmpty()) {
                        System.out.println("Receb: " + inputLine);
                        String textUpper = processarTexto(inputLine);
                        os.println(textUpper);
                        os.flush();
                        System.out.println("Send:  " + textUpper);

                        updateClient(socket);

                        if (inputLine.equals("END")) {
                            System.out.println("End connection for: " + socket.toString());
                            removeClient(socket);
                        }

                        if (inputLine.equals("STOP")) {
                            stopServer(socket);
                        }

                    }
                } catch (java.net.SocketTimeoutException ex) {
                    // OMITIR - ESPERO QUE ACONTEÇA TIMEOUT
                    // VAI CONTINUAR 
                }
            }
            System.out.println("END client: " + socket.toString()
                    + ", with thread: " + Thread.currentThread());
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    private String getSocketInfo(Socket socket) {
        return "" + socket.getInetAddress() + ":" + socket.getPort();
    }

    private void cleanUp1() {
        cleanupExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                clients.forEach((key, client) -> {
                    //MAIS 60000 MS elimina
                    if (new Date().getTime() - client.getLastConnectionTime().getTime() > 60000) {

                        try {
                            System.out.println("Fechar socket client, Muito tempo: " + client.getClietnSocket());
                            //client.getClietnSocket().close();

                            if (!client.getClietnSocket().isClosed()) {
                                clients.remove(key);
                            }
                        } catch (Exception ex) {
                            LOG.log(Level.SEVERE, "Erro ao fechar socket client via clean: ", ex);
                        }
                    }
                });

            }
        }, 15, 30, TimeUnit.SECONDS);
    }

    private void waitForClientSocketClose() {

        cleanupExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                if (clients.isEmpty()) {
                    exitAtomic.set(true);
                }

            }
        }, 1, 3, TimeUnit.SECONDS);

        if (!clients.isEmpty()) {
            System.out.println("BaseTCPServer wait For all ClientSocket Close");
            exitAtomic.get(); //BLOCK HERE
        }
        try {
            cleanupExecutorService.shutdownNow();
            cleanupExecutorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            LOG.log(Level.SEVERE, "Erro ao terminar o Cleanup ExecutorService", ex);
        }
    }

    private String getSocketId(Socket socket) {
        return socket.toString().toUpperCase();
    }

    private void addClient(Socket socket) {
        String clientId = getSocketId(socket);
        if (!clients.contains(clientId)) {
            clients.put(clientId, new Client(new Date(), socket));
            System.out.println("Added new client: " + socket.toString());
        }
    }

    private void updateClient(Socket socket) {
        String clientId = getSocketId(socket);

        Client cl = clients.get(clientId);

        if (cl != null) {
            cl.setLastConnectionTime(new Date());
            System.out.println("Update client: " + socket.toString());
        }
    }

    private void removeClient(Socket socket) {
        String clientId = getSocketId(socket);

        clients.remove(clientId);
        System.out.println("Remove client: " + clientId);

        try {
            socket.close();
            System.out.println("Close client: " + socket.toString());
        } catch (IOException ex) {
            Logger.getLogger(BaseTCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void stopServer(Socket socket) {
        System.out.println("Call Stop server from: " + socket.toString());
        removeClient(socket);
        setNotAlive();
    }

    synchronized private boolean isAlive() {
        return isAlive;
    }

    synchronized private void setNotAlive() {
        isAlive = false;
    }

    private String processarTexto(String text) {
        return text.toUpperCase();
    }

    @Override
    public void init() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Servidor escuta em " + serverSocket.toString());
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    abstract protected void onClientConnection(Socket clientSocket);

    public class Client {

        private Date lastConnectionTime;
        private Socket clietnSocket;

        public Client(Date lastConnectionTime, Socket clietnSocket) {
            this.lastConnectionTime = lastConnectionTime;
            this.clietnSocket = clietnSocket;
        }

        public Date getLastConnectionTime() {
            return lastConnectionTime;
        }

        public void setLastConnectionTime(Date lastConnectionTime) {
            this.lastConnectionTime = lastConnectionTime;
        }

        public Socket getClietnSocket() {
            return clietnSocket;
        }

        public void setClietnSocket(Socket clietnSocket) {
            this.clietnSocket = clietnSocket;
        }

        @Override
        public String toString() {
            return "[Client: " + clietnSocket.toString()
                    + ", lastConnection: " + lastConnectionTime
                    + "]";
        }
    }

}
