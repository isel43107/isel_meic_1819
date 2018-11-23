/**
 * ISEL - MEIC - Engenharia de Software 2018/2019 
 * Trabalho 02 - SGPF - Consola
 * 
 * 44442 (João Costa)
 * 43107 (Paulo Borges)
 */
package isel.es1819.jp.sgpfconsole;

import java.util.Scanner;

/**
 *
 * @author jcosta
 */
public class SGPFMainController {

    SGPFMainMenuView mainMenuView = new SGPFMainMenuView();
    SGPFMainMenuModel mainMenuModel = new SGPFMainMenuModel();

    public void executar() {
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                mainMenuView.showMenu();
                String opcao = in.nextLine();
                if (opcao.equals("sair")) {
                    break;
                }
                if (!opcao.isEmpty()) {
                    mainMenuModel.opcaoHandler(opcao.charAt(0));
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
        //new ConsolaProjetoController(new InMemoryProjetoModel());
        
        
        SGPFMainController app = new SGPFMainController();
        app.executar();
    }
}
