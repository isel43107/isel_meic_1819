/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.aula.torniquete;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pauloborges
 */
public class TorniqueTeste {

    public static void main(String[] args) {
        Torniquete torniquete = new Torniquete();
        torniquete.iniciar();
        torniquete.executar();
    }
}
