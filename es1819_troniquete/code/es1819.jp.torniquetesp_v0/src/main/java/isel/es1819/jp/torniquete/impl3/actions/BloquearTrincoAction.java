/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.torniquete.impl3.actions;

import isel.es1819.jp.torniquete.impl3.Torniquete.Events;
import isel.es1819.jp.torniquete.impl3.Torniquete.States;
import java.util.Map;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

/**
 *
 * @author pauloborges
 */
public class BloquearTrincoAction implements Action<States, Events> {

    @Override
    public void execute(StateContext<States, Events> context) {
        System.out.println("Acao BLOQUERAR");
        /**
        Map<Object, Object> variables = context.getExtendedState().getVariables();
        
        
        Integer foo = context.getExtendedState().get("foo", Integer.class);
        if (foo == null) {
            System.out.println("Init foo to 0");
            variables.put("foo", 0);
        } else if (foo == 0) {
            System.out.println("Switch foo to 1");
            variables.put("foo", 1);
        } else if (foo == 1) {
            System.out.println("Switch foo to 0");
            variables.put("foo", 0);
        }
        */
    }
}