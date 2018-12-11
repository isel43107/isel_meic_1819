/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.sgpfdado.utilizador;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author pauloborges
 */

@Entity
@Table(name = "UTILIZADOR")
public class Utilizador implements Serializable {
   
    @Id
    @Column(name = "nome_autenticacao", updatable = false, nullable = false)
    private String nomeAutenticacao;

    @Column(name = "nome_completo")
    private String nomeCompleto;
    
    @Column(name = "palavra_chave")
    private String palavraChave;
    private TipoUtilizador tipoUtilizador;

    public String getNomeAutenticacao() {
        return nomeAutenticacao;
    }

    public void setNomeAutenticacao(String nomeAutenticacao) {
        this.nomeAutenticacao = nomeAutenticacao;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getPalavraChave() {
        return palavraChave;
    }

    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }

    public TipoUtilizador getTipoUtilizador() {
        return tipoUtilizador;
    }

    public void setTipoUtilizador(TipoUtilizador tipoUtilizador) {
        this.tipoUtilizador = tipoUtilizador;
    }
    
    public enum TipoUtilizador{
        TECNICO,
        GESTOR_FINANCIAMENTO,
        COMISSAO_FINANCIAMENTO;
    }
}
