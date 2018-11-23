/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmpratica01.server;

import java.net.Socket;

/**
 *
 * @author pauloborges
 */
public class TCPServerThread extends BaseTCPServer{

    public TCPServerThread(int port) {
        super(port);
        System.out.println("Server new Thread per client");
    }

    @Override
    protected void onClientConnection(final Socket clientSocket) {
        
        Thread clientThread = new Thread(() -> {
            processSocket(clientSocket);
        });
        
        clientThread.start();
    }
    
    public static void main(String[] args) {
        ServerAPI serverAPI1 = new TCPServerThread(9002);
        serverAPI1.init();
        serverAPI1.start();
    }
}
