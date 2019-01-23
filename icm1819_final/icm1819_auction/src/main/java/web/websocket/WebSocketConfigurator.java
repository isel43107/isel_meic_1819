/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.websocket;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 *
 * @author pauloborges
 */
public class WebSocketConfigurator extends ServerEndpointConfig.Configurator {

    private static final String ORIGIN = "http://localhost:8080";

    @Override
    public boolean checkOrigin(String originHeaderValue) {
        return true;
        //return ORIGIN.equals(originHeaderValue);
    }

    @Override
    public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        
        super.modifyHandshake(config, request, response);
        
        if (httpSession == null) {
            httpSession = (HttpSession) request.getHttpSession();
        }

        if (httpSession == null) {
            return;
        }

        config.getUserProperties().put("httpSession", httpSession);
    }
}
