/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmpratica01.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pauloborges
 */
public class TCPClient implements ClientAPI {

    private final static Logger LOG = Logger.getLogger(TCPClient.class.getName());

    private final static int TIMEOUT = 30000;
    private final String host;
    private final int port;
    private Socket sockfd = null;
    private PrintWriter os = null;
    private BufferedReader is = null;

    public TCPClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void connect() {
        try {
            sockfd = new Socket(host, port);
            sockfd.setSoTimeout(TIMEOUT);
            if (sockfd != null) {
                System.out.println("Client " + sockfd.getLocalAddress() + ":" + sockfd.getLocalPort()
                        + ", contect to " + sockfd.getInetAddress() + ":" + sockfd.getPort());
                os = new PrintWriter(sockfd.getOutputStream(), true);
                is = new BufferedReader(new InputStreamReader(sockfd.getInputStream()));
            }
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Erro no estabelecimento da ligação:", ex);
            throw new RuntimeException("Erro no estabelecimento da ligação: ", ex);
        }
    }

    @Override
    public String send(String text) {

        String response = "";

        try {
            os.println(text);
            os.flush();
            response = is.readLine();
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Cannot read response, because ioxecption: ", ex);
            throw new RuntimeException("Cannot read response, because ioxecption: ", ex);
        }
        return response;
    }

    @Override
    public void close() {
        try {
            if (os != null) {
                os.close();
            }
            if (is != null) {
                is.close();
            }
            if (sockfd != null) {
                sockfd.close();
            }
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void main(String[] args) {
        clientStart("localhost", 9005);
    }
    
    
    public static void clientStart(String host, int port){
        //ClientAPI tcpClient = new UDPClient(host, port);
        ClientAPI tcpClient = new TCPClient(host, port);
        tcpClient.connect();

        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter text :");
                String texto = in.nextLine();

                String res = tcpClient.send(texto);
                System.out.println("Received: " + res);

                if (texto.equals("END") || texto.equals("STOP")) {
                    tcpClient.close();
                    break;
                }
            }
        }
    }
}
