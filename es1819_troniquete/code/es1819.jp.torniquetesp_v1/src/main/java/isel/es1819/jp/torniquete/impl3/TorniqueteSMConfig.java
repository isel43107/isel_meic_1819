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
import isel.es1819.jp.torniquete.impl3.actions.ActivarAlarmeAction;
import isel.es1819.jp.torniquete.impl3.actions.BloquearTrincoAction;
import isel.es1819.jp.torniquete.impl3.actions.DesactivarAlarmeAction;
import isel.es1819.jp.torniquete.impl3.actions.DesbloquearTrincoAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.config.configurers.StateConfigurer.History;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;


@Configuration
@EnableStateMachine
public class TorniqueteSMConfig
        extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
            throws Exception {
        config
        .withConfiguration()
        .autoStartup(true)
        .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        
        states
        .withStates()
            .initial(States.MODO_NORMAL)
            .state(States.MODO_DIAGNOSTICO)
            .and()
            .withStates()
                .parent(States.MODO_NORMAL)
                .initial(States.BLOQUEADO)
                .state(States.BLOQUEADO, bloquearTrincoAction(), null)
                .state(States.ALARME, activarAlarmeAction(), desactivarAlarmeAction())
                .state(States.DESBLOQUEADO, desbloquearTrincoAction())
                .history(States.HISTORY, History.SHALLOW)
                .and()
            .withStates()
                .parent(States.MODO_DIAGNOSTICO)
                .initial(States.TESTAR_CARTAO)
                .state(States.TESTAR_CARTAO,bloquearTrincoAction())
                .state(States.TESTAR_PASSAGEM,desbloquearTrincoAction());
        
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                
                /* MODO NORMAL */
                .withExternal()
                .source(States.BLOQUEADO).target(States.ALARME).event(Events.PASSAGEM)
                .and()
                .withExternal()
                .source(States.ALARME).target(States.BLOQUEADO).event(Events.REINICIAR)
                .and()
                .withExternal()
                .source(States.BLOQUEADO).target(States.DESBLOQUEADO).event(Events.CARTAO)
                .and()
                .withExternal()
                .source(States.DESBLOQUEADO).target(States.BLOQUEADO).event(Events.PASSAGEM)
                 /* MODO DIAGNOSTICO */
                .and()
                .withExternal()
                .source(States.TESTAR_CARTAO).target(States.TESTAR_PASSAGEM).event(Events.CARTAO)
                .and()
                .withExternal()
                .source(States.TESTAR_PASSAGEM).target(States.TESTAR_CARTAO).event(Events.PASSAGEM)
                
                 /* TORNIQUETE */
                .and()
                .withExternal()
                .source(States.MODO_NORMAL).target(States.MODO_DIAGNOSTICO).event(Events.DIAGNOSTICO)
                .and()
                .withExternal()
                .source(States.MODO_DIAGNOSTICO).target(States.MODO_NORMAL).event(Events.REINICIAR)
                .and()
                .withExternal()
                .source(States.MODO_DIAGNOSTICO).target(States.HISTORY).event(Events.TERMINAR_DIAGNOSTICO);
    }

    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>() {
            @Override
            public void stateChanged(State<States, Events> from, State<States, Events> to) {
                System.out.println("State change to " + to.getId());
            }
        };
    }

    @Bean
    public BloquearTrincoAction bloquearTrincoAction() {
        return new BloquearTrincoAction();
    }
    
    
    @Bean
    public DesbloquearTrincoAction desbloquearTrincoAction() {
        return new DesbloquearTrincoAction();
    }
    
    @Bean
    public ActivarAlarmeAction activarAlarmeAction() {
        return new ActivarAlarmeAction();
    }
    
    
    @Bean
    public DesactivarAlarmeAction desactivarAlarmeAction() {
        return new DesactivarAlarmeAction();
    }
}
