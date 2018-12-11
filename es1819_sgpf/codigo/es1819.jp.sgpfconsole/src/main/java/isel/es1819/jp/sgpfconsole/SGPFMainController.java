/**
 * ISEL - MEIC - Engenharia de Software 2018/2019 
 * Trabalho 02 - SGPF - Consola
 * 
 * 44442 (João Costa)
 * 43107 (Paulo Borges)
 */
package isel.es1819.jp.sgpfconsole;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author jcosta
 */
public class SGPFMainController {

    SGPFMainMenuView mainMenuView = new SGPFMainMenuView();
    SGPFMainMenuModel mainMenuModel = new SGPFMainMenuModel();

    public void executar() {
        
        SgpfBaseRunner runner = new SgpfBaseRunner();
        runner.run(null);
/*
            while (true) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                    br.reset();
                    mainMenuView.showMenu();
                    String opcao = br.readLine();
                    if (opcao.equals("sair")) {
                        break;
                    }
                    if (!opcao.isEmpty()) {
                        mainMenuModel.opcaoHandler(opcao.charAt(0));
                    }
                }catch(Exception ex){}
            }
*/
    }
    
    public static void main(String[] args) {
        
        //new ConsolaProjetoController(new InMemoryProjetoModel());
        
        
        SGPFMainController app = new SGPFMainController();
        app.executar();
    }
}
