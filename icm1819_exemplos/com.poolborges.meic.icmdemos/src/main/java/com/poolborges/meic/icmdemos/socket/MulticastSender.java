/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmdemos.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pauloborges
 */
public class MulticastSender {

    public static void main(String[] args) {
        InetAddress ia = null;
        int port = 4001;
        byte ttl = (byte) 1;
        String host = null;
        try {
            ia = InetAddress.getByName("224.2.127.254");
            host = InetAddress.getLocalHost().getHostName();
        } catch (Exception ex) {
            System.err.println("MulticastSender Error:" + ex);
            System.exit(1);
        }
        byte[] data = (host + ":Here's some multicast data").getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);

        try {
            MulticastSocket ms = new MulticastSocket();
            ms.joinGroup(ia);
            ms.setTimeToLive(ttl);
            ms.send(dp);
            ms.leaveGroup(ia);
            ms.close();
        } catch (SocketException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
