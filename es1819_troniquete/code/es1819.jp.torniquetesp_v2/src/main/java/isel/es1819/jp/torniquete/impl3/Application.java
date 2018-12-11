/**
 * ISEL - MEIC - Engenharia de Software 2018/2019
 * Trabalho 01 - Torniquete
 *
 * 44442 (João Costa)
 * 43107 (Paulo Borges)
 */
package isel.es1819.jp.torniquete.impl3;

import isel.es1819.jp.torniquete.impl3.gui.Torniquete1GUI;
import isel.es1819.jp.torniquete.impl3.Torniquete.Events;
import isel.es1819.jp.torniquete.impl3.Torniquete.States;
import java.awt.EventQueue;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class Application {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
/*
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Application.class)
                .headless(false)
                .web(false)
                .run(args);

        EventQueue.invokeLater(() -> {
            Torniquete1GUI ex = ctx.getBean(Torniquete1GUI.class);
            ex.setVisible(true);
        });
        */
    }

    @Bean
    public PromptProvider myPromptProvider() {
        return () -> new AttributedString("torniquete-shell:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
    }

}
