/**
 * ISEL - MEIC - Engenharia de Software 2018/2019 
 * Trabalho 02 - SGPF - Consola
 * 
 * 44442 (João Costa)
 * 43107 (Paulo Borges)
 */
package isel.es1819.jp.sgpfconsole.model;

/**
 *
 * @author pauloborges
 */
public class Projeto {

    private String numero;
    private String tipo; //(incentivo, bonificação),
    private String montante;// de financiamento solicitado
    private String descricao;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMontante() {
        return montante;
    }

    public void setMontante(String montante) {
        this.montante = montante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * projecto de financiamento
     *
     * Designação, nacionalidade e NIF do promotor, NIB da conta bancária
     * associada, responsável por contactos (designação, e-mail, telefone), tipo
     * de projecto (Incentivo ou Bonificação), montante de financiamento
     * solicitado, descrição do projecto
     */
    
    
}
