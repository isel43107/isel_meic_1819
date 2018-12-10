/**
 * ISEL - MEIC - Engenharia de Software 2018/2019 
 * Trabalho 02 - SGPF - Consola
 * 
 * 44442 (João Costa)
 * 43107 (Paulo Borges)
 */
package isel.es1819.jp.sgpfconsole.controller;

import isel.es1819.jp.sgpfconsole.model.ProjetoModel;
import isel.es1819.jp.sgpfconsole.view.ProjetoView;

/**
 *
 * @author pauloborges
 */
public class ConsolaProjetoController implements ProjetoController {
    
    private ProjetoModel projetoModel;
    private ProjetoView projetoView;

    public ConsolaProjetoController(ProjetoModel projetoModel) {
        this.projetoModel = projetoModel;
    }


    private void obterIdentificaProjeto() {
        
    }

    @Override
    public void aceitacaoCandidatura() {
        //Obter dados teclato sobre a candidatura
        //validar
        // validar que o estado do projeto permite esta acao. projetoModel.persistir
        //
    }

    @Override
    public void aberturaProjeto() {
    }

    @Override
    public void parecerTecnico() {
    }

    @Override
    public void despachoComisaoFinanciamento() {
    }

    @Override
    public void suspensaoProjeto() {
    }

    @Override
    public void reativacaoProjeto() {
    }

    @Override
    public void reforcoProjeto() {
    }

    @Override
    public void realizacaoProjeto() {
    }

    @Override
    public void alteracaoDadosProjeto() {
    }

    @Override
    public void relatorioInformacaoProjeto() {
    }

    @Override
    public void relatorioPagamentoProjeto() {
    }
}
