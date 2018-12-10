/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmpratica01.server;

import java.net.DatagramPacket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author pauloborges
 */
public class UDPServerThreadpoll extends BaseUDPServer{

    private final ExecutorService executorService;

    public UDPServerThreadpoll(int port) {
        super(port);
        executorService = Executors.newCachedThreadPool();
        System.out.println("UDPServerThreadpoll - newCachedThreadPool");
        
    }
    @Override
    protected void onClientConnection(DatagramPacket datagramPacket) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                processSocket(datagramPacket);
            }
        });
    }
    public static void main(String[] args) {
         
        ServerAPI serverAPI3 = new UDPServerThreadpoll(9004);
        serverAPI3.init();
        serverAPI3.start();
        
    }
    
}
