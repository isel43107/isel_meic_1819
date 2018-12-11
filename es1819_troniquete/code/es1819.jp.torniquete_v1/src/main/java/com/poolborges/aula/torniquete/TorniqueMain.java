/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.aula.torniquete;

import com.lympid.core.behaviorstatemachines.StateMachine;
import com.lympid.core.behaviorstatemachines.StateMachineExecutor;
import com.lympid.core.behaviorstatemachines.builder.StateMachineBuilder;
import com.lympid.core.behaviorstatemachines.impl.SyncStateMachineExecutor;
import com.lympid.core.common.Copyable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pauloborges
 */
public class TorniqueMain {

    public static void main(String[] args) {
        TorniqueMain tSM = new TorniqueMain();
        StateMachine machine = tSM.torniqueteSM().newInstance(); // builds and validates the state machine; the result is cached
/*
        StateMachineExecutor fsm = new SyncStateMachineExecutor.Builder<>();
        fsm.setStateMachine(machine);
        fsm.go();
         */
    }

    public StateMachineBuilder torniqueteSM() {
        StateMachineBuilder<Context> builder = new StateMachineBuilder<>("Torniquete");

        builder.region()
                .initial("init")
                .transition("t0")
                .target("modoNormal");

        builder.region()
                .state(modoNormalSM("modoNormal"))
                .entry(c -> c.enteredSubMachine = true)
                .exit(c -> c.exitedSubMachine = true)
                .transition("t1")
                .target("end");

        return builder;
    }

    private StateMachineBuilder<Context> modoNormalSM(final String name) {
        StateMachineBuilder<Context> builder = new StateMachineBuilder<>(name);

        builder
                .region()
                .initial("init")
                .transition("t0")
                .target("A");

        builder
                .region()
                .state("A")
                .transition("t1")
                .on("go")
                .target("end");

        builder
                .region()
                .finalState("end");

        return builder;
    }

    public static final class Context implements Copyable<Context> {

        boolean enteredSubMachine;
        boolean exitedSubMachine;

        @Override
        public Context copy() {
            Context copy = new Context();
            copy.enteredSubMachine = enteredSubMachine;
            copy.exitedSubMachine = exitedSubMachine;
            return copy;
        }
    }
}
