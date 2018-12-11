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
public class TorniqueteMaquinaEstados extends MaquinaEstados {

    public TorniqueteMaquinaEstados(){
       this(Estado.BLOQUEADO);
    }
    
    public TorniqueteMaquinaEstados(Estado estadoInicial){
       super(estadoInicial);
    }
    
    @Override
    void setTabelaTransicao(){
        tabelaTransicaoEstado.put(Evento.PASSAGEM_DETECTADA,Estado.DESBLOQUEADO, Estado.BLOQUEADO);
        tabelaTransicaoEstado.put(Evento.PASSAGEM_DETECTADA,Estado.BLOQUEADO, Estado.ALARME);
        tabelaTransicaoEstado.put(Evento.REINICIAR_OPERACAO,Estado.ALARME, Estado.BLOQUEADO);
        tabelaTransicaoEstado.put(Evento.CARTAO_DETECTADO,Estado.BLOQUEADO, Estado.DESBLOQUEADO);
    }
    
    @Override
    void setActivacaoEstado(){
        tabelaActivacaoEstado.put(Evento.CARTAO_DETECTADO,Estado.BLOQUEADO, Accao.DESBLOQUEAR);
        tabelaActivacaoEstado.put(Evento.PASSAGEM_DETECTADA,Estado.DESBLOQUEADO, Accao.BLOQUEAR);
        tabelaActivacaoEstado.put(Evento.PASSAGEM_DETECTADA,Estado.BLOQUEADO, Accao.ACTIVAR_SIRENE);
        tabelaActivacaoEstado.put(Evento.REINICIAR_OPERACAO,Estado.ALARME, Accao.DESACTIVAR_SIRENE);
    }
}
