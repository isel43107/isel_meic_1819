/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmwebsocket;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author pauloborges
 */

@ServerEndpoint("/echo")
public class EchoServer {
    
   
    @OnOpen
    public void onOpen(Session session){
        System.out.println("onOpen: EchoServer instance: "+this);
    }
    
    //@OnMessage
    public String onMessage1(String message, Session session){
    
        System.out.println("onMessage: "+message);
        return message.toUpperCase();
    }
    
    @OnMessage
    public void onMessage(String message, Session session){
    
        System.out.println("onMessage: "+message);
        RemoteEndpoint.Basic other = session.getBasicRemote();
        try {
            other.sendText(message.toUpperCase());
        } catch (IOException ex) {
            Logger.getLogger(EchoServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @OnError
    public void onError(Throwable throwable){
    
        System.out.println("onError");
    }
    
    @OnClose
    public void onClose(Session session){
    
        System.out.println("onClose");
    }
    
}
