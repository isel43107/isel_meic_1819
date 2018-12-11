/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.sgpfdado;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "HISTORICO")
public class Historico extends BaseEntity {

    @Column(name = "evento")
    private String evento;
    
    @Column(name = "estado_atual")
    private String estadoAtual;
    
    @Column(name = "estado_proximo")
    private String estadoProximo;
    
    @Column(name = "acao")
    private String acao;
    
    @Column(name = "utilizador")
    private String utilizador;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="projeto_codigo", nullable = false, unique = false)
    private ProjetoFinanciamento numeroProjeto;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_execucao")
    private Date dataExecucao;


    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(String estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public String getEstadoProximo() {
        return estadoProximo;
    }

    public void setEstadoProximo(String estadoProximo) {
        this.estadoProximo = estadoProximo;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public ProjetoFinanciamento getNumeroProjeto() {
        return numeroProjeto;
    }

    public void setNumeroProjeto(ProjetoFinanciamento numeroProjeto) {
        this.numeroProjeto = numeroProjeto;
    }

    public Date getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(Date dataExecucao) {
        this.dataExecucao = dataExecucao;
    }
    
    
}
