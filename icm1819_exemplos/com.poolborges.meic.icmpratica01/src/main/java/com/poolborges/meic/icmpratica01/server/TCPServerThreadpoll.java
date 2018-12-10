/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmpratica01.server;

import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author pauloborges
 */
public class TCPServerThreadpoll extends BaseTCPServer{

    private final ExecutorService executorService;

    public TCPServerThreadpoll(int port) {
        super(port);
        executorService = Executors.newCachedThreadPool();
        System.out.println("Server newCachedThreadPool");
        
    }
    
    
    @Override
    protected void onClientConnection(Socket clientSocket){

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                processSocket(clientSocket);
                
            }
        });
    }
    
    public static void main(String[] args) {
        
        ServerAPI serverAPI2 = new TCPServerThreadpoll(9003);
        serverAPI2.init();
        serverAPI2.start();
    }
}


