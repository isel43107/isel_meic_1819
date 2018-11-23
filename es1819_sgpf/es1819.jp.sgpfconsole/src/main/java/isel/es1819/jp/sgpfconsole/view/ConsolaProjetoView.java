/**
 * ISEL - MEIC - Engenharia de Software 2018/2019 
 * Trabalho 02 - SGPF - Consola
 * 
 * 44442 (João Costa)
 * 43107 (Paulo Borges)
 */
package isel.es1819.jp.sgpfconsole.view;

import isel.es1819.jp.sgpfconsole.model.Projeto;

/**
 *
 * @author pauloborges
 */
public class ConsolaProjetoView implements ProjetoView {

    @Override
    public void mostraRelatorioProjeto(Projeto projeto){}
    
    @Override
    public void mostrarInformacaoProjeto(Projeto projeto){
        System.out.println("Projeto");
        System.out.println("Numero: " + projeto.getNumero());
        System.out.println("Tipo: " + projeto.getTipo());
    }
}
