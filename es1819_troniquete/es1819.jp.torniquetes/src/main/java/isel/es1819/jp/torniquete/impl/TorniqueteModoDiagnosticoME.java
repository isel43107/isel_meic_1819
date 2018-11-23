/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.torniquete.impl;

/**
 *
 * @author pauloborges
 */
public class TorniqueteModoDiagnosticoME extends MaquinaEstados{
    
    
    public TorniqueteModoDiagnosticoME(Estado estadoIncial) {
        super(estadoIncial, false);
        setTabelaTransicao();
    }
            
    public TorniqueteModoDiagnosticoME() {
        this(Estado.BLOQUEADO);
    }
    
    private void setTabelaTransicao(){
        //BLOQUEADO - DESBLOQUEADO
        adicionarTransicao(Estado.BLOQUEADO, Evento.CARTAO_DETECTADO, Accao.DESBLOQUEAR, Estado.DESBLOQUEADO);
        adicionarTransicao(Estado.DESBLOQUEADO, Evento.PASSAGEM_DETECTADA, Accao.BLOQUEAR, Estado.BLOQUEADO);
        
        //BLOQUEADO - ALARME
        adicionarTransicao(Estado.BLOQUEADO, Evento.PASSAGEM_DETECTADA, Accao.ACTIVAR_SIRENE, Estado.ALARME);
        adicionarTransicao(Estado.DESBLOQUEADO, Evento.PASSAGEM_DETECTADA, Accao.BLOQUEAR, Estado.BLOQUEADO);
    }
    
}
