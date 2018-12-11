/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.torniquete.impl2;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;


/**
 *
 * @author pauloborges
 */
public class Estado {
    
    private final Table<Estado,Evento,Estado> tabelaTransicaoEstado = HashBasedTable.create();
    
    Acao entradaAcao;
    Acao saidaAcao;
    
    
    public Estado(Acao acaoEntrada, Acao acaoSaida){
        this.entradaAcao = acaoEntrada;
        this.saidaAcao = acaoSaida;
    }
    
    public void execucao(){
    
    }
    
    public Acao entrada(){
        return entradaAcao;
    }

    public Acao saida(){
        return entradaAcao;
    }
    
    public void addtransicoes(Evento event,Estado estadoDestino){
        tabelaTransicaoEstado.put(this, event, estadoDestino);
    }
}
