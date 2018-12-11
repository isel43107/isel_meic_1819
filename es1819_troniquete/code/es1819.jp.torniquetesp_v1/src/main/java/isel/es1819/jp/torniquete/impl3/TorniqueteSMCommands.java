/**
 * ISEL - MEIC - Engenharia de Software 2018/2019 
 * Trabalho 01 - Torniquete
 * 
 * 44442 (João Costa)
 * 43107 (Paulo Borges)
 */
package isel.es1819.jp.torniquete.impl3;

import isel.es1819.jp.torniquete.impl3.Torniquete.Events;
import isel.es1819.jp.torniquete.impl3.Torniquete.States;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.util.StringUtils;

@ShellComponent
public class TorniqueteSMCommands {
    
    
    @Autowired
	private StateMachine<States, Events> stateMachine;

	protected StateMachine<States, Events> getStateMachine() {
		return stateMachine;
	}

        @ShellMethod(key = "sm-evento-list", value = "Mostra todos os eventos")
	public String eventos() {
		State<States, Events> state = stateMachine.getState();
		if (state != null) {
			return StringUtils.collectionToCommaDelimitedString(Arrays.asList(Events.values()));
		} else {
			return "Sem eventos";
		}
	}
        
	@ShellMethod(key = "sm-estado", value = "Mostrar estado actual")
	public String state() {
		State<States, Events> state = stateMachine.getState();
		if (state != null) {
			return StringUtils.collectionToCommaDelimitedString(state.getIds());
		} else {
			return "Sem estado";
		}
	}

	@ShellMethod(key =  "sm-iniciar", value = "Inicia a maquina de estado")
	public String start() {
		stateMachine.start();
		return "Maquina de estado iniciou";
	}

	@ShellMethod(key = "sm-parar", value = "Parar a maquina de estado")
	public String stop() {
		stateMachine.stop();
		return "Maquina de estado parou";
	}


	@ShellMethod(key = "sm-evento", value = "Enviar um evento para a maquina de estado")
	public String event(final Events event) {
		getStateMachine().sendEvent(event);
		return "Evento " + event + " enviado";
	}

}
