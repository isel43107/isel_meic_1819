/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmwebsocket;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
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
@ServerEndpoint("/chat")
public class ChatServer {
    
    private int username;
    private Session userSession;
    
    //Use static objects for SHARED data
    private static AtomicInteger counter = new AtomicInteger(0);
    private static final Set<WeakReference<ChatServer>> connectins = new CopyOnWriteArraySet<>();
    private WeakReference<ChatServer> my = new WeakReference<>(this);
    

    public ChatServer() {

    }

    @OnOpen
    public void onOpen(Session session) {

        System.out.println("onOpen, sessionId: "+ session.getId() +", chatServer instance: " + this);
        username = counter.getAndIncrement();
        connectins.add(my);
    }

    @OnMessage
    public void onMessage(String message, Session session) {

        System.out.println("onMessage: "+message);
        session.getOpenSessions().forEach((t) -> {
            RemoteEndpoint.Basic other = t.getBasicRemote();
            try {
                other.sendText(username + ":" + message.toUpperCase());
            } catch (IOException ex) {
                //connectins.add(t);
                Logger.getLogger(EchoServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @OnError
    public void onError(Throwable throwable) {

        System.out.println("onError: "+throwable);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("onClose: "+session.getId());
    }

}
