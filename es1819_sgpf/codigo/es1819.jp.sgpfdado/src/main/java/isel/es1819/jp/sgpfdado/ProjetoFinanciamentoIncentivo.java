/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.sgpfdado;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author pauloborges
 */
@Entity
@Table(name = "PROJETOFINANCIAMENTO_INCENTIVO")
public class ProjetoFinanciamentoIncentivo extends ProjetoFinanciamento{
    
    private int numeroPrestacoes;

    public int getNumeroPrestacoes() {
        return numeroPrestacoes;
    }

    public void setNumeroPrestacoes(int numeroPrestacoes) {
        this.numeroPrestacoes = numeroPrestacoes;
    }
    
    
}
