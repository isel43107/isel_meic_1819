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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name = "PROJETOFINANCIAMENTO")
@Inheritance(strategy = InheritanceType.JOINED)
public class ProjetoFinanciamento extends BaseEntity {
    
    @Column(name = "numero_projecto", updatable = false, nullable = true)
    private String numeroProjecto;
    
    @Column(name = "descricao", updatable = true, nullable = true)
    private String descricao;
    
    //Valor atribuidi
    @Column(name = "custo_elegivel")
    private double custoElegivel;
    
    //Valor Solicitado
    @Column(name = "montante_financiamento")
    private double montanteFinanciamento;
    
    @Column(name = "conta_bancaria")
    private String contaBancaria;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_criacao")
    private Date dataCriacao;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="promotor_codigo", nullable = true)
    private Promotor promotor;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="responsavel_contato_codigo", nullable = true)
    private ResponsavelContato responsavelContato;

    public String getNumeroProjecto() {
        return numeroProjecto;
    }

    public void setNumeroProjecto(String numeroProjecto) {
        this.numeroProjecto = numeroProjecto;
    }

    public double getCustoElegivel() {
        return custoElegivel;
    }

    public void setCustoElegivel(double custoElegivel) {
        this.custoElegivel = custoElegivel;
    }

    public double getMontanteFinanciamento() {
        return montanteFinanciamento;
    }

    public void setMontanteFinanciamento(double montanteFinanciamento) {
        this.montanteFinanciamento = montanteFinanciamento;
    }

    public String getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(String contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Promotor getPromotor() {
        return promotor;
    }

    public void setPromotor(Promotor promotor) {
        this.promotor = promotor;
    }

    public ResponsavelContato getResponsavelContato() {
        return responsavelContato;
    }

    public void setResponsavelContato(ResponsavelContato responsavelContato) {
        this.responsavelContato = responsavelContato;
    }
    
    enum TipoFinanciamento {
        INCENTIVO,
        BONIFICACAO;
    }
    
    
}
