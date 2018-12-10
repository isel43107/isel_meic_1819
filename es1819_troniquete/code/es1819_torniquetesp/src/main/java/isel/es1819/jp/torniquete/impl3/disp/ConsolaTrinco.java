/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.torniquete.impl3.disp;

import org.springframework.stereotype.Component;

/**
 *
 * @author pauloborges
 */
@Component
public class ConsolaTrinco implements Trinco{

    @Override
    public void bloquear() {
        System.out.println("Bloquear Trinco"); 
    }

    @Override
    public void desbloquear() {
        System.out.println("Desbloquear Trinco"); 
    }
    
}
