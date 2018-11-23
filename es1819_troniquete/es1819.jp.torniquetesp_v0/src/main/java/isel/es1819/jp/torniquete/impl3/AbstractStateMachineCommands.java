/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.torniquete.impl3;

import isel.es1819.jp.torniquete.impl3.Torniquete.Events;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
/**
 *
 * @author pauloborges
 */
@Component
public class AbstractStateMachineCommands<S, E>{

	@Autowired
	private StateMachine<S, E> stateMachine;

	protected StateMachine<S, E> getStateMachine() {
		return stateMachine;
	}

        @ShellMethod(key = "sm-eventos", value = "Mostra todos os eventos")
	public String eventos() {
		State<S, E> state = stateMachine.getState();
		if (state != null) {
			return StringUtils.collectionToCommaDelimitedString(Arrays.asList(Events.values()));
		} else {
			return "Sem eventos";
		}
	}
        
	@ShellMethod(key = "sm-estado", value = "Mostrao estado actual")
	public String state() {
		State<S, E> state = stateMachine.getState();
		if (state != null) {
			return StringUtils.collectionToCommaDelimitedString(state.getIds());
		} else {
			return "No state";
		}
	}

	@ShellMethod(key =  "sm-iniciar", value = "Inicia a maquina de estado")
	public String start() {
		stateMachine.start();
		return "Mauuina de estado iniciou";
	}

	@ShellMethod(key = "sm-stop", value = "Parar a maquina de estado")
	public String stop() {
		stateMachine.stop();
		return "State machine stopped";
	}


	@ShellMethod(key = "sm-variaveis", value = "Prints extended state variables")
	public String variables() {
		StringBuilder buf = new StringBuilder();
		Set<Entry<Object, Object>> entrySet = stateMachine.getExtendedState().getVariables().entrySet();
		Iterator<Entry<Object, Object>> iterator = entrySet.iterator();
		if (entrySet.size() > 0) {
			while (iterator.hasNext()) {
				Entry<Object, Object> e = iterator.next();
				buf.append(e.getKey() + "=" + e.getValue());
				if (iterator.hasNext()) {
					buf.append("\n");
				}
			}
		} else {
			buf.append("No variables");
		}
		return buf.toString();
	}

}