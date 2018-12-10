/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.torniquete.impl3;

import isel.es1819.jp.torniquete.impl3.Torniquete.Events;
import isel.es1819.jp.torniquete.impl3.Torniquete.States;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.statemachine.StateMachine;

/**
 *
 * @author pauloborges
 */
@SpringBootApplication
public class Application {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    /*
    @Override
    public void run(String... args) throws Exception {

        stateMachine.sendEvent(Events.PASSAGEM);
        stateMachine.sendEvent(Events.CARTAO);
        stateMachine.sendEvent(Events.PASSAGEM);
    }
*/

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        
        //SpringApplication.run(Application.class, args);
    }

    @Bean
    public PromptProvider myPromptProvider() {
        return () -> new AttributedString("torniquete-shell:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
    }

}
