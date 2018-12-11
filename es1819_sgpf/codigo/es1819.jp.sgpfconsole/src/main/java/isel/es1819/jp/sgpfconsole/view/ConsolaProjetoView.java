/**
 * ISEL - MEIC - Engenharia de Software 2018/2019 
 * Trabalho 02 - SGPF - Consola
 * 
 * 44442 (João Costa)
 * 43107 (Paulo Borges)
 */
package isel.es1819.jp.sgpfconsole.view;

import isel.es1819.jp.sgpfdado.ProjetoFinanciamento;


/**
 *
 * @author pauloborges
 */
public class ConsolaProjetoView implements ProjetoView {

    @Override
    public void mostraRelatorioProjeto(ProjetoFinanciamento projeto){}
    
    @Override
    public void mostrarInformacaoProjeto(ProjetoFinanciamento projeto){
        System.out.println("Projeto");
        System.out.println("Numero: " + projeto.getNumeroProjecto());
        System.out.println("Tipo: " + projeto.getClass());
    }
}
