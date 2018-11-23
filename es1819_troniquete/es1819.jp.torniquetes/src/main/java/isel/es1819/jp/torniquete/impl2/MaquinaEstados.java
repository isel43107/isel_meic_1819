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
public abstract class MaquinaEstados {
    
    private final Table<Estado,Evento,Estado> tabelaTransicaoEstado = HashBasedTable.create();
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

    protected void adicionarTransicao(Estado es,Evento ev, Estado proxES){
        tabelaTransicaoEstado.put(es, ev, proxES);
    }
    
    protected Estado getProximoEstado(Estado es, Evento ev, Acao ac, Estado proxES){
        return tabelaTransicaoEstado.get(es, ev);
    }
}
