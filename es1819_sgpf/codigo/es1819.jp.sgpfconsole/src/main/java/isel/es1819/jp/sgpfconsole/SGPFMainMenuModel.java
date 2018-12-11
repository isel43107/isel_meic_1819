/**
 * ISEL - MEIC - Engenharia de Software 2018/2019 
 * Trabalho 02 - SGPF - Consola
 * 
 * 44442 (João Costa)
 * 43107 (Paulo Borges)
 */
package isel.es1819.jp.sgpfconsole;

import isel.es1819.jp.sgpfconsole.controller.SgpfImpl;

/**
 *
 * @author jcosta
 */
public class SGPFMainMenuModel {
    
    SgpfImpl proController;
    
    //TODO Receber o controller no construtor
    public SGPFMainMenuModel(){
        proController = new SgpfImpl();
    }

    public void opcaoHandler(char opcao) {
        
        //TODO verificar a maquina de estado 
        //

        switch (opcao) {

            case 'a':
                proController.aceitacaoCandidatura();
                break;
            case 'b':
                proController.despachoAberturaProjeto();
                break;
            case 'c':
                proController.parecerTecnico();
                break;
            case 'd':
                // Devera processar o despacho de acordo com o numero de projeto
                proController.despachoAberturaProjeto();
                proController.despachoFinanciamento();
                proController.despachoReforcoFinanciamento();
                break;
            case 'e':
                proController.suspensaoProjeto();
                break;
            case 'f':
                proController.reativacaoProjeto();
                break;
            case 'g':
                proController.reforcoProjeto();
                break;
            case 'h':
                proController.realizacaoPagamento();
                break;
            case 'i':
                proController.alteracaoDadosProjeto();
                break;
            case 'j':
                proController.relatorioInformacaoProjeto();
                break;
            case 'k':
                proController.relatorioPagamentoProjeto();
                break;

            default:
                System.out.println("Não existe a opcao: " + opcao);
                break;
        }
    }
}
