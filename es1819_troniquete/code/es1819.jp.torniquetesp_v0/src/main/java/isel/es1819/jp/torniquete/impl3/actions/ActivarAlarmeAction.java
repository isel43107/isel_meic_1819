/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.torniquete.impl3.actions;

import isel.es1819.jp.torniquete.impl3.Torniquete.Events;
import isel.es1819.jp.torniquete.impl3.Torniquete.States;
import isel.es1819.jp.torniquete.impl3.utils.SoundUtils;
import java.awt.Toolkit;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

/**
 *
 * @author pauloborges
 */
public class ActivarAlarmeAction implements Action<States, Events> {

    @Override
    public void execute(StateContext<States, Events> context) {
        System.out.println("Acao ActivarAlarmeAction");
        
        Toolkit.getDefaultToolkit().beep();
        SoundUtils.tone(1000, 100);
    }
}