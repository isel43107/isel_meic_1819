/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmpratica01.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pauloborges
 */
public class UDPClient implements ClientAPI {
    
    private final static Logger LOG = Logger.getLogger(UDPClient.class.getName());

    private final static int TIMEOUT = 4000;
    private final static int BUFFER_SIZE = 100;
    private final String host;
    private final int port;
    private DatagramSocket sockfd = null;

    public UDPClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void connect() {
        try {
            sockfd = new DatagramSocket();
            sockfd.setSoTimeout(TIMEOUT);
        } catch (SocketException e) {
            LOG.log(Level.SEVERE, "Erro inciar client side udp ", e.getMessage());
        }
    }

    @Override
    public String send(String ext) {

        String received = null;
        try {
            // Mostrar os parametros da ligação
            System.out.println("Para servidor: " + host + ": " + port 
                    + ", from: " + sockfd.getLocalAddress() + ": " + sockfd.getLocalPort());

            // constroi mensagem e Envia pedido
            DatagramPacket epacket = new DatagramPacket(ext.getBytes(), ext.length(), InetAddress.getByName(host), port);

            try {
                sockfd.send(epacket);
            } catch (IOException e) {
                LOG.log(Level.SEVERE, "Erro no envio da mensagem: ", e.getMessage());
            }
            
            // Recebe resposta
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                DatagramPacket rpacket = new DatagramPacket(buf, buf.length);
                sockfd.receive(rpacket);

                received = new String(rpacket.getData(), 0, rpacket.getLength());
            } catch (IOException e) {
                LOG.log(Level.SEVERE, "Erro na recepção da mensagem: ", e.getMessage());
            }

        } catch (UnknownHostException ex) {
            LOG.log(Level.SEVERE, "Exception ao enviar msg: ", ex);
        }

        return received;
    }

    @Override
    public void close() {
        sockfd.close();
    }
    
    
    public static void main(String[] args) {
        clientStart("localhost", 9004);
    }
    
    
    public static void clientStart(String host, int port){
        ClientAPI tcpClient = new UDPClient(host, port);
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
