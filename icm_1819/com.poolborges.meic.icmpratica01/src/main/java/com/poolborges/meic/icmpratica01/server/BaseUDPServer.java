/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmpratica01.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pauloborges
 */
public abstract class BaseUDPServer implements ServerAPI {

    private final static Logger LOG = Logger.getLogger(BaseUDPServer.class.getName());

    private final static int TIMEOUT = 4000;
    private DatagramSocket serverSocket;
    private final int port;
    private final static int BUFFER_SIZE = 100;
    private boolean isAlive = true;

    ConcurrentHashMap<String, Client> clients = new ConcurrentHashMap<>();

    public BaseUDPServer(int port) {
        this.port = port;
    }

    @Override
    public void start() {

        while (isAlive) {
            try {
                byte ibuffer[] = new byte[BUFFER_SIZE];
                DatagramPacket rpacket = new DatagramPacket(ibuffer, BUFFER_SIZE);

                serverSocket.receive(rpacket);
                onClientConnection(rpacket);
                addClient(rpacket);
            }catch(SocketTimeoutException ex){
                //IGNORE SIMPLEMENTE se for TIMEOUT
            }catch (IOException ex) {
                LOG.log(Level.SEVERE, "Erro no servidor:", ex);
                break;
            }
        }
    }

    @Override
    public void stop() {
        isAlive = false;
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
            System.err.println("STOP FORCE - VERY STUPID");
            System.exit(0);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    protected void processSocket(final DatagramPacket rpacket) {

        if (rpacket == null) {
            return;
        }

        System.out.println("Processar client: " + getSocketId(rpacket));

        try {
            String inputLine = new String(rpacket.getData(), 0, rpacket.getLength());

            System.out.println("Recebi -> " + inputLine);
            String textUpper = processarTexto(inputLine);

            sendResponde(rpacket.getAddress(), rpacket.getPort(), textUpper);
            System.out.println("Send:  " + textUpper);
            if (inputLine.endsWith("END")) {
                removeClient(rpacket);
            }

            if (inputLine.endsWith("STOP")) {
                stopServer(rpacket);
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    synchronized private void sendResponde(InetAddress host, int port, String text) {
        DatagramPacket epacket = new DatagramPacket(text.getBytes(), text.length(), host, port);
        try {
            serverSocket.send(epacket);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Erro no envio da resposta", ex);
        }
    }

    private void addClient(DatagramPacket packet) {
        String clientId = getSocketId(packet);
        if (!clients.contains(clientId)) {
            clients.put(clientId, new Client(new Date(), clientId));
            System.out.println("Added new client: " + clientId);
        }
    }

    private String getSocketId(DatagramPacket ds) {
        return "[" + ds.getAddress() + ":" + ds.getPort() + "]".toUpperCase();
    }

    private void removeClient(DatagramPacket packet) {
        String clientId = getSocketId(packet);

        clients.remove(clientId);
        System.out.println("Remove client: " + clientId);
    }

    private void stopServer(DatagramPacket packet) {
        System.out.println("Call Stop server from: " + getSocketId(packet));
        removeClient(packet);
        stopServer();

    }

    private void stopServer() {
        System.out.println("Connects clients: " + clients.size());
        if (clients.isEmpty()) {
            stop();
        }
    }

    private String processarTexto(String text) {
        return text.toUpperCase();
    }

    @Override
    public void init() {
        try {
            serverSocket = new DatagramSocket(port);
            serverSocket.setSoTimeout(TIMEOUT);
            System.out.println("UDPServidor escuta em " + getDatagramSocket(serverSocket));
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Erro ao iniciar o server", ex);
        }
    }

    private String getDatagramSocket(DatagramSocket ds) {
        return "[" + ds.getLocalAddress() + ":" + ds.getLocalPort() + "]";
    }

    abstract protected void onClientConnection(DatagramPacket clientSocket);

    public class Client {

        private Date lastConnectionTime;
        private String clietnSocket;

        public Client(Date lastConnectionTime, String clietnSocket) {
            this.lastConnectionTime = lastConnectionTime;
            this.clietnSocket = clietnSocket;
        }

        public Date getLastConnectionTime() {
            return lastConnectionTime;
        }

        public void setLastConnectionTime(Date lastConnectionTime) {
            this.lastConnectionTime = lastConnectionTime;
        }

        public String getClietnSocket() {
            return clietnSocket;
        }

        public void setClietnSocket(String clietnSocket) {
            this.clietnSocket = clietnSocket;
        }

        @Override
        public String toString() {
            return "[Client: " + clietnSocket
                    + ", lastConnection: " + lastConnectionTime
                    + "]";
        }
    }

}
