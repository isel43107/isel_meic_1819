/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmpratica01.client;

/**
 *
 * @author pauloborges
 */
public interface ClientAPI {
    
    public void connect();
    public String send(String ext);
    public void close();
}
