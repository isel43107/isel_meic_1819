/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmpratica01.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pauloborges
 */
public class MulticastClient implements ClientAPI {

    private final static Logger LOG = Logger.getLogger(MulticastClient.class.getName());

    private int port = 4001;
    private String host = "224.0.0.0"; // "224.2.127.254" "224.0.0.0"
    private InetAddress groupInetAddress = null;
    private final byte TTL = (byte) 1;
    private MulticastSocket multicastSocket = null;

    public MulticastClient(String host, int port) {
        this.port = port;
        this.host = host;
        //host = InetAddress.getLocalHost().getHostName();
    }

    @Override
    public void connect() {
        connectToAll();
    }
    
    private void connectToAll(){
        
        getGoodNetworkInterfaces().forEach(netInterface -> {
            connectMC(netInterface);
        });
    }

    private NetworkInterface getFirstNetinterface() {
        Optional<NetworkInterface> optionaInterface = getGoodNetworkInterfaces().stream().findFirst();

        if (!optionaInterface.isPresent()) {
            LOG.log(Level.SEVERE, "Can not found any non localhost network interface ready to use or UP");
        }
        NetworkInterface networkInterface = optionaInterface.get();
        return networkInterface;
    }

    private void connectMC(NetworkInterface networkInterface) {

        try {

            groupInetAddress = InetAddress.getByName(host);

            multicastSocket = new MulticastSocket(port);
            multicastSocket.setSoTimeout(10000);
            multicastSocket.setTimeToLive(TTL);
            multicastSocket.joinGroup(new InetSocketAddress(groupInetAddress, port), networkInterface);
            //multicastSocket.joinGroup(groupInetAddress);

        } catch (SocketException ex) {
            LOG.log(Level.SEVERE, "Erro abrir ligação(SocketException)", ex);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Erro abrir ligação(IOException)", ex);
        }
    }

    @Override
    public void close() {

        try {
            multicastSocket.leaveGroup(groupInetAddress);
            multicastSocket.close();
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "erro fechar ligação", ex);
        }
    }

    @Override
    public String send(String texto) {

        String result = "";
        try {
            sendData(texto);
            result = recieved();
        } catch (SocketException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }

        return result;
    }

    private void sendData(String texto) throws IOException {
        byte[] data = texto.getBytes();
        DatagramPacket snd = new DatagramPacket(data, data.length, groupInetAddress, port);
        multicastSocket.send(snd);
        System.out.println("Sended " + snd.getLength() + " bytes.");
    }

    private String recieved() throws SocketException, IOException {

        byte[] buf = new byte[8096];
        DatagramPacket recv = new DatagramPacket(buf, buf.length);
        multicastSocket.receive(recv);
        System.out.println("Recieved " + recv.getLength() + " bytes.");

        return new String(recv.getData());

    }

    private List<NetworkInterface> getGoodNetworkInterfaces() {
        List<NetworkInterface> builder = new ArrayList<>();

        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                try {
                    if (!networkInterface.isLoopback() && networkInterface.isUp()) {
                        builder.add(networkInterface);
                    }
                } catch (SocketException ignored) {
                    //OMMITED EXCEPTION, IGNORE
                }
            }
        } catch (SocketException ignored) {
        }
        return builder;
    }
    
    
    public static void main(String[] args) {

        String host = "224.0.0.0";
        int port = 9003;

        Scanner s = new Scanner(System.in);
        try (Scanner in = new Scanner(System.in)) {
            // Reads a single line from the console
            // and stores into name variable
            System.out.println("Enter host :");
            host = in.nextLine();

            // Reads a integer from the console
            // and stores into age variable
            System.out.println("Enter port :");
            port = in.nextInt();
        }
        
        clientMCStart(host, port);
    }
    
    private static void clientMCStart(String host, int port){
        //ClientAPI tcpClient = new UDPClient(host, port);
        ClientAPI tcpClient = new MulticastClient(host, port);
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
