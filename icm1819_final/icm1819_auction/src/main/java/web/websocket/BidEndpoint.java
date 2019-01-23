/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author pauloborges
 */
@ServerEndpoint(value = "/websocket/bid/{productId}")
public class BidEndpoint {

    private Session session;
    private static Set<BidEndpoint> chatEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> users = new HashMap<>();

    @OnOpen
    public void onOpen(
            Session session,
            EndpointConfig config,
            @PathParam("productId") String productId) throws IOException {

        this.session = session;
        chatEndpoints.add(this);
        users.put(productId, session.getId());
        
        
        //config.getUserProperties();

        /*
        Message message = new Message();
        message.setFrom(username);
        message.setContent("Connected!");
        broadcast(message);
         */
    }

    @OnMessage
    public void onMessage(Session session, final String message)
            throws IOException {
        /*
        message.setFrom(users.get(session.getId()));
        broadcast(message);
         */
    }

    @OnClose
    public void onClose(Session session) throws IOException {

        chatEndpoints.remove(this);

        /*
        Message message = new Message();
        message.setFrom(users.get(session.getId()));
        message.setContent("Disconnected!");
 
        broadcast(message);
         */
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }

    private static void broadcast(String message)
            throws IOException, EncodeException {

        chatEndpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    endpoint.session.getBasicRemote().
                            sendObject(message);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
