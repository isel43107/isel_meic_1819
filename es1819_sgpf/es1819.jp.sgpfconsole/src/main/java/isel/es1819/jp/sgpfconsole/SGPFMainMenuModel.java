/**
 * ISEL - MEIC - Engenharia de Software 2018/2019 
 * Trabalho 02 - SGPF - Consola
 * 
 * 44442 (João Costa)
 * 43107 (Paulo Borges)
 */
package isel.es1819.jp.sgpfconsole;

import isel.es1819.jp.sgpfconsole.controller.ConsolaProjetoController;
import isel.es1819.jp.sgpfconsole.model.InMemoryProjetoModel;

/**
 *
 * @author jcosta
 */
public class SGPFMainMenuModel {
    
    ConsolaProjetoController proController;
    
    //TODO Receber o controller no construtor
    public SGPFMainMenuModel(){
        proController = new ConsolaProjetoController(new InMemoryProjetoModel());
    }

    public void opcaoHandler(char opcao) {

        switch (opcao) {

            case 'a':
                proController.aceitacaoCandidatura();
                break;
            case 'b':
                break;
            case 'c':
                break;
            case 'd':
                break;
            case 'e':
                break;
            case 'f':
                break;
            case 'g':
                break;
            case 'h':
                break;
            case 'i':
                break;
            case 'j':
                break;
            case 'k':
                break;

            default:
                System.out.println("Não existe a opcao: " + opcao);
                break;
        }
    }
}
