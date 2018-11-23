/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.aula.torniquete;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pauloborges
 */
public class Detector {

    public Evento detectar() {
        Evento event = getEvento();
        return event;
    }

    private Evento randomEvento() {
        List<Evento> VALUES
                = Collections.unmodifiableList(Arrays.asList(Evento.values()));
        int SIZE = VALUES.size();
        Random RANDOM = new Random();
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
    
    private Evento getEvento(){
        String texto = "";
        System.out.println("Escolha o evento: cartao, passagem, reiniciar, terminar");
        Evento evento = null;
        try (Scanner in = new Scanner(System.in)) {
            texto = in.nextLine();
            switch(texto){
                case "cartao":
                    evento = Evento.CARTAO_DETECTADO;
                    break;
                case "passagem":
                    evento = Evento.CARTAO_DETECTADO;
                    break;
                case "reiniciar":
                    evento = Evento.CARTAO_DETECTADO;
                    break;
                case "terminar":
                    evento = Evento.CARTAO_DETECTADO;
                    break;
            }
            
        }
        return evento;
    }

}
