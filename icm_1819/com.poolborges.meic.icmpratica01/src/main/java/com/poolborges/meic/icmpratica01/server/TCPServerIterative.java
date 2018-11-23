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
public class TCPServerIterative extends BaseTCPServer {

    public TCPServerIterative(int port) {
        super(port);
        System.out.println("Server iterative one client");
    }

    @Override
    protected void onClientConnection(Socket clientSocket) {
        processSocket(clientSocket);
    }
    
     public static void main(String[] args) {
         
        ServerAPI serverAPI = new TCPServerIterative(9001);
        serverAPI.init();
        serverAPI.start();
     }

}
