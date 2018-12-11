/**
 * ISEL - MEIC - Engenharia de Software 2018/2019 
 * Trabalho 01 - Torniquete
 * 
 * 44442 (João Costa)
 * 43107 (Paulo Borges)
 */
package isel.es1819.jp.torniquete.impl3;

public class Torniquete {

    public enum States {
        MODO_NORMAL, MODO_DIAGNOSTICO, DESBLOQUEADO, BLOQUEADO, ALARME, TESTAR_CARTAO, TESTAR_PASSAGEM,
        HISTORY
    }

    public enum Events {
        CARTAO, PASSAGEM, REINICIAR, DIAGNOSTICO, TERMINAR_DIAGNOSTICO
    }
}
