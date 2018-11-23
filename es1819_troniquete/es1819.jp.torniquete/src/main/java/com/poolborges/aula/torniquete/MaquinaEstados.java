/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.aula.torniquete;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 *
 * @author pauloborges
 */
public abstract class MaquinaEstados {
    
    //Tabela Transição de Estado MAP<<Estado,Evento>, Estado>
    //Tabela Activação de Estado (Acca) : MAP<<Estado,Evento>, Accao>
    //map.put(new MultiKey(url, today),
    protected Table<Evento, Estado, Accao> tabelaActivacaoEstado = HashBasedTable.create();
    protected Table<Evento, Estado, Estado> tabelaTransicaoEstado = HashBasedTable.create();
    protected Estado estado;

    public MaquinaEstados(Estado estadoInicial) {
        this.estado = estadoInicial;
        setTabelaTransicao();
        setActivacaoEstado();
    }

    public Accao processar(Evento evento) {
        Accao accao = tabelaActivacaoEstado.get(evento, estado);
        Estado estadoNovo = tabelaTransicaoEstado.get(evento, estado);

        System.out.println("Evento: " + evento + ", Estado: " + estado + ", Accao: " + accao + ", EstadoNov: " + estadoNovo);
        if (estadoNovo != null) {
            estado = estadoNovo;
        }
        return accao;
    }
    
    abstract void setTabelaTransicao();
    
    abstract void setActivacaoEstado(); 
}
