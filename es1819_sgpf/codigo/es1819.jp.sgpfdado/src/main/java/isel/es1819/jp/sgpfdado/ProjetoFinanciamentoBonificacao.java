/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.sgpfdado;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pauloborges
 */
@Entity
@Table(name = "PROJETOFINANCIAMENTO_BONIFICACAO")
public class ProjetoFinanciamentoBonificacao extends ProjetoFinanciamento{
    
    /**
     * Periodo bonificação 
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "periodo_inicio")
    private Date periodoInicio;
    
    @Column(name = "periodo_fim")
    @Temporal(TemporalType.DATE)
    private Date periodoFim;
    
    @Column(name = "taxa_bonificacao")
    private double taxaBonificacao;
    
    @Column(name = "montante_max_bonificacao")
    private double montanteMaximoBonificacao;

    public Date getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(Date periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public Date getPeriodoFim() {
        return periodoFim;
    }

    public void setPeriodoFim(Date periodoFim) {
        this.periodoFim = periodoFim;
    }

    public double getTaxaBonificacao() {
        return taxaBonificacao;
    }

    public void setTaxaBonificacao(double taxaBonificacao) {
        this.taxaBonificacao = taxaBonificacao;
    }

    public double getMontanteMaximoBonificacao() {
        return montanteMaximoBonificacao;
    }

    public void setMontanteMaximoBonificacao(double montanteMaximoBonificacao) {
        this.montanteMaximoBonificacao = montanteMaximoBonificacao;
    }
    
    
}
