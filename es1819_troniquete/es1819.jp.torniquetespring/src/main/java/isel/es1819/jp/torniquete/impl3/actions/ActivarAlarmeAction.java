/**
 * ISEL - MEIC - Engenharia de Software 2018/2019 
 * Trabalho 01 - Torniquete
 * 
 * 44442 (João Costa)
 * 43107 (Paulo Borges)
 */
package isel.es1819.jp.torniquete.impl3.actions;

import isel.es1819.jp.torniquete.impl3.Torniquete.Events;
import isel.es1819.jp.torniquete.impl3.Torniquete.States;
import isel.es1819.jp.torniquete.impl3.disp.Sirene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;


public class ActivarAlarmeAction implements Action<States, Events> {
    
    @Autowired
    Sirene sirene;

    @Override
    public void execute(StateContext<States, Events> context) {
        //System.out.println("Acao ACTIVAR alarme");
        
        sirene.activarAlarme();
    }
}