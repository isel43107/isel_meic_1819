/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmpratica01;

/**
 *
 * @author pauloborges
 */
public enum Command {

    END("END"),
    STOP("STOP");

    private final String command;

    private Command(String commmand) {
        this.command = commmand;
    }

    
    @Override
    public String toString(){
        return command;
    }
    
}
