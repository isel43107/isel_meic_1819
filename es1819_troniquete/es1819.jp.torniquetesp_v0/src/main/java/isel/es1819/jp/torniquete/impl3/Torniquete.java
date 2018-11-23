/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.torniquete.impl3;

/**
 *
 * @author pauloborges
 */
public class Torniquete {

    public enum States {
        MODO_NORMAL, MODO_DIAGNOSTICO, DESBLOQUEADO, BLOQUEADO, ALARME, TESTAR_CARTAO, TESTAR_PASSAGEM,
        HISTORY
    }

    public enum Events {
        CARTAO, PASSAGEM, REINICIAR, DIAGNOSTICO, TERMINAR_DIAGNOSTICO
    }
}
