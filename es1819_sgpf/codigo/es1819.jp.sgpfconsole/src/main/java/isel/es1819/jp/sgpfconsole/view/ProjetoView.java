/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.sgpfconsole.view;

import isel.es1819.jp.sgpfdado.ProjetoFinanciamento;

/**
 *
 * @author pauloborges
 */
public interface ProjetoView {

    void mostraRelatorioProjeto(ProjetoFinanciamento projeto);

    void mostrarInformacaoProjeto(ProjetoFinanciamento projeto);
    
}
