/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "bid")
public class Licitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    
    @JoinColumn(name = "comprador_id")
    @ManyToOne
    private User comprador;
    
    @Column(name = "valor_licitacao")
    private double valorLicitacao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_licitacao")
    private Date dataLicitacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public User getComprador() {
        return comprador;
    }

    public void setComprador(User comprador) {
        this.comprador = comprador;
    }

    public double getValorLicitacao() {
        return valorLicitacao;
    }

    public void setValorLicitacao(double valorLicitacao) {
        this.valorLicitacao = valorLicitacao;
    }

    public Date getDataLicitacao() {
        return dataLicitacao;
    }

    public void setDataLicitacao(Date dataLicitacao) {
        this.dataLicitacao = dataLicitacao;
    }
    
    
}
