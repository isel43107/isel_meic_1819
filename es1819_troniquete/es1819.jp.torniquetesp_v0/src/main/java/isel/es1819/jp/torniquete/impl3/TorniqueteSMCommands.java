/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.torniquete.impl3;

import isel.es1819.jp.torniquete.impl3.Torniquete.Events;
import isel.es1819.jp.torniquete.impl3.Torniquete.States;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 *
 * @author pauloborges
 */
@ShellComponent
public class TorniqueteSMCommands extends AbstractStateMachineCommands<States, Events> {

	@ShellMethod(key = "sm-event", value = "Sends an event to a state machine")
	public String event(final Events event) {
		getStateMachine().sendEvent(event);
		return "Event " + event + " send";
	}

}
