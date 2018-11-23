/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmdemos.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pauloborges
 */
public class MulticastListner {

    final static int PORT = 4001;
    final static String IP = "224.0.0.0";
    //final static String IP = "224.2.127.254";

    private final static Logger LOG = Logger.getLogger(MulticastListner.class.getName());
    
    
    

    public static void main(String[] args) throws IOException {
        //listner1();
        listener2();
    }
    
    
    private static void listner1(){
    
        InetAddress mAddr = null;
        MulticastSocket mSocket = null;

        try {
            mAddr = InetAddress.getByName(IP);
            mSocket = new MulticastSocket(PORT);
            String hostname = InetAddress.getLocalHost().getHostName();

            System.out.println("Preparing Listening from " + hostname + " at " + mAddr.getHostName());
            byte[] buffer = new byte[8192];
            mSocket.joinGroup(mAddr);

            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            while (true) {
                mSocket.receive(dp);
                String str = new String(dp.getData());
                System.out.println(str);
            }//end of while
        } catch (SocketException se) {
            LOG.log(Level.SEVERE, "Socket Exception : ", se);
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "IOException : ", e);
        } finally {
            if (mSocket != null) {
                try {
                    mSocket.leaveGroup(mAddr);
                    mSocket.close();
                } catch (IOException e) {
                }
            }//end of if
        }//end of finally
    }

    private static void listener2() throws SocketException, IOException {

        Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
        Optional<NetworkInterface> optionaInterface = getGoodNetworkInterfaces().stream().findFirst();

        if(!optionaInterface.isPresent()){
            LOG.log(Level.SEVERE, "Can not found any non localhost network interface ready to use or UP");
            return;
        }
        
        NetworkInterface networkInterface = optionaInterface.get();
        
        InetAddress group = InetAddress.getByName(IP);
        MulticastSocket s = new MulticastSocket(PORT);
        s.setSoTimeout(10000);
        //s.joinGroup(group); //this will throw "No such device" exception 
        s.joinGroup(new InetSocketAddress(group, PORT), networkInterface);

        for (int i = 0; i < 10; ++i) {
            byte[] buf = new byte[8096];
            DatagramPacket recv = new DatagramPacket(buf, buf.length);
            s.receive(recv);
            System.out.println("Recieved " + recv.getLength() + " bytes.");
        }

        s.leaveGroup(group);
    }

    private static List<NetworkInterface> getGoodNetworkInterfaces() {
        List<NetworkInterface> builder = new ArrayList<>();
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                try {
                    if (!networkInterface.isLoopback() && networkInterface.isUp()) {
                        builder.add(networkInterface);
                    }
                } catch (Exception ignored) {
                    //OMMITED EXCEPTION, IGNORE
                }
            }
        } catch (SocketException ignored) {
        }
        return builder;
    }
}
