/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.sgpfdado;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pauloborges
 */
@Entity
@Table(name = "PAGAMENTO")
public class Pagamento extends BaseEntity {

    @Temporal(TemporalType.DATE)
    @Column(name = "data_pagamento")
    private Date dataPagamento;
    
    @Column(name = "valor")
    private double valor;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="projeto_codigo", nullable = false, unique = false)
    private ProjetoFinanciamento projetoFinanciamento;


    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ProjetoFinanciamento getProjetoFinanciamento() {
        return projetoFinanciamento;
    }

    public void setProjetoFinanciamento(ProjetoFinanciamento projetoFinanciamento) {
        this.projetoFinanciamento = projetoFinanciamento;
    }
    
    
}
