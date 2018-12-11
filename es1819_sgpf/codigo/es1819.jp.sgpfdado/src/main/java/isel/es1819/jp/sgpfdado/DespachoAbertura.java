/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.sgpfdado;

import isel.es1819.jp.sgpfdado.utilizador.Utilizador;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author pauloborges
 */
@Entity
@Table(name = "DESPACHO_ABERTURA")
public class DespachoAbertura extends Despacho{
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="gestor_financiamento", nullable = false, unique = false)
    private Utilizador gestorFinanceiro;

    public Utilizador getGestorFinanceiro() {
        return gestorFinanceiro;
    }

    public void setGestorFinanceiro(Utilizador gestorFinanceiro) {
        this.gestorFinanceiro = gestorFinanceiro;
    }
    
    
}
