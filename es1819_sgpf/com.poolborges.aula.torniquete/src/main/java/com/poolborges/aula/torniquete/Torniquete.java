/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.aula.torniquete;

/**
 *
 * @author pauloborges
 */
public class Torniquete {

    private Detector detector = new Detector();
    private Trinco trinco = new Trinco();
    private Sirene sirene = new Sirene();
    private TorniqueteMaquinaEstados maqEstado = new TorniqueteMaquinaEstados();

    private void processar(Evento evento) {

        Accao accao = maqEstado.processar(evento);

        if (accao != null) {

            switch (accao) {

                case BLOQUEAR:
                    trinco.bloquear();
                    break;

                case DESBLOQUEAR:
                    trinco.desbloquear();
                    break;

                case ACTIVAR_SIRENE:
                    sirene.activar();
                    break;

                case DESACTIVAR_SIRENE:
                    sirene.deactivar();
                    break;
                default:
                    break;
            }
        }
    }

    public void iniciar() {
        System.out.println("Iniciar torniquete: ");

    }

    public void executar() {

        while (true) {
            Evento evento = detector.detectar();
            processar(evento);
        }

    }
}
