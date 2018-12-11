/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.torniquete.impl3.gui;

import isel.es1819.jp.torniquete.impl3.Torniquete;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.PrintStream;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

/**
 *
 * @author pauloborges
 */
//@Component
public class Torniquete1GUI extends JFrame {

    @Autowired
    private StateMachine<Torniquete.States, Torniquete.Events> stateMachine;

    private JTextArea textArea;

    private JTextArea messageArea;

    private JButton buttonStart = new JButton("send event");
    private JButton buttonClear = new JButton("Clear");

    private PrintStream standardOut;

    public Torniquete1GUI() {
        super("Torniquete GUI");

        textArea = new JTextArea(50, 10);
        textArea.setEditable(false);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));

        messageArea = new JTextArea(1, 10);
        messageArea.setEditable(true);

        // keeps reference of standard output stream
        standardOut = System.out;

        // re-assigns standard output stream and error output stream
        System.setOut(printStream);
        System.setErr(printStream);

        // creates the GUI
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.WEST;

        // FIRST LINE
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        //constraints.weightx = 1.0;
        //constraints.weighty = 1.0;
        add(new JScrollPane(messageArea), constraints);

        // NEXT LINE 
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        add(buttonStart, constraints);

        constraints.gridx = 1;
        add(buttonClear, constraints);

        // NEXT LINE 
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        add(new JScrollPane(textArea), constraints);

        // adds event handler for button Start
        buttonStart.addActionListener((ActionEvent evt) -> {
            //printLog();
            sendEvent(messageArea.getText());
        });

        // adds event handler for button Clear
        buttonClear.addActionListener((ActionEvent evt) -> {
            // clears the text area
            try {
                textArea.getDocument().remove(0, textArea.getDocument().getLength());
                standardOut.println("Text area cleared");
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 320);
        setLocationRelativeTo(null);	// centers on screen
    }

    private void sendEvent(String event) {

        String lowString = event.toUpperCase();
        switch (event) {
            case "CARTAO":
                stateMachine.sendEvent(Torniquete.Events.CARTAO);
                break;
            case "PASSAGEM":
                stateMachine.sendEvent(Torniquete.Events.CARTAO);
                break;
            case "REINICIAR":
                stateMachine.sendEvent(Torniquete.Events.CARTAO);
                break;
            case "DIAGNOSTICO":
                stateMachine.sendEvent(Torniquete.Events.CARTAO);
                break;
            case "TERMINAR_DIAGNOSTICO":
                stateMachine.sendEvent(Torniquete.Events.CARTAO);
                break;
            default:
                printHelp();
                break;

        }
    }

    private void printHelp() {
        System.out.println("Eventos possiveis: ");
        System.out.println("CARTAO, PASSAGEM, REINICIAR, DIAGNOSTICO, TERMINAR_DIAGNOSTICO");
    }

    private void printLog() {

        System.out.println("Time now is " + (new Date()));
        /*
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Time now is " + (new Date()));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        thread.start();
         */
    }

    /**
     * Runs the program
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Torniquete1GUI().setVisible(true);
            }
        });
    }

    public static void main2(String[] args) {

        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Torniquete1GUI.class)
                .headless(false)
                .web(false)
                .run(args);

        SwingUtilities.invokeLater(() -> {
            Torniquete1GUI ex = ctx.getBean(Torniquete1GUI.class);
            ex.setVisible(true);
        });
    }
}
