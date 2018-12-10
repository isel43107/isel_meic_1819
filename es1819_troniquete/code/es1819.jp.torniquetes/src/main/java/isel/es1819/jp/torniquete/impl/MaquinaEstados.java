/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.torniquete.impl;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
/**
 *
 * @author pauloborges
 */
public abstract class MaquinaEstados {
    
    private final Table<Estado,Evento,Oupput> tabelaTransicaoEstado = HashBasedTable.create();
    private Estado estadoAtual;

    private boolean historico;
    
    public MaquinaEstados(Estado estadoIncial, boolean historico){
        this.estadoAtual = estadoIncial;
        this.historico = historico;
    }
    
    private void inicio(){
        
    }
    
    private void historico(){
    
    }

    protected void adicionarTransicao(Estado es,Evento ev, Accao ac, Estado proxES){
        tabelaTransicaoEstado.put(es, ev, new Oupput(ac, proxES));
    }
    
    protected Estado getProximoEstado(Estado es, Evento ev, Accao ac, Estado proxES){
        Oupput output = tabelaTransicaoEstado.get(es, ev);
        return output.proximoEstado;
    }
    
    protected Accao getAcao(Estado es, Evento ev){
        Oupput output = tabelaTransicaoEstado.get(es, ev);
        return output.acao;
    }
    
    private class Oupput {
        
        private final Estado proximoEstado;
        private final Accao acao;

        public Oupput(Accao acao, Estado proximoEstado) {
            this.proximoEstado = proximoEstado;
            this.acao = acao;
        }

        public Estado getProximoEstado() {
            return proximoEstado;
        }

        public Accao getAcao() {
            return acao;
        }
        
        
    }
}
