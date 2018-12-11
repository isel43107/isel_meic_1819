/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.sgpfdado;

import isel.es1819.jp.sgpfdado.utilizador.Utilizador;
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

/**
 *
 * @author pauloborges
 */
@Entity
@Table(name = "DESPACHO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Despacho extends BaseEntity {

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataDecisao;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="emitido_por", nullable = false, unique = false)
    private Utilizador emitidoPor;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="projeto_codigo", nullable = false, unique = false)
    private ProjetoFinanciamento projeto;
    
    @Column(name = "decisao", nullable = false, unique = false)
    private boolean decisao;

    

    public Utilizador getEmitidoPor() {
        return emitidoPor;
    }

    public void setEmitidoPor(Utilizador emitidoPor) {
        this.emitidoPor = emitidoPor;
    }

    public ProjetoFinanciamento getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoFinanciamento projeto) {
        this.projeto = projeto;
    }

    public boolean isDecisao() {
        return decisao;
    }

    public void setDecisao(boolean decisao) {
        this.decisao = decisao;
    }

    public Date getDataDecisao() {
        return dataDecisao;
    }

    public void setDataDecisao(Date dataDecisao) {
        this.dataDecisao = dataDecisao;
    }
    
}
