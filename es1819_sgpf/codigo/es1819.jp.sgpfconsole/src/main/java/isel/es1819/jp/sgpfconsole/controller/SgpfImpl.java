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
import isel.es1819.jp.sgpfdado.ProjetoFinanciamentoIncentivo;
import isel.es1819.jp.sgpfdado.dao.ProjetoDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pauloborges
 */
public class SgpfImpl implements ProjetoController, ParecerController, DespachoController, PagamentoController  {

    private ProjetoModel projetoModel;
    private ProjetoView projetoView;

    public SgpfImpl() {
        //this.projetoModel = projetoModel;
    }

    @Override
    public void aceitacaoCandidatura() {
        //Obter dados teclato sobre a candidatura
        //validar
        // validar que o estado do projeto permite esta acao. projetoModel.persistir
        //
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                    

            /*
            //Responsável por contactos (designação, e-mail, telefone),
            String designacaoR = in.nextLine();
            String email = in.nextLine();
            String telefone = in.nextLine();
            
            //Promotor (Designação, nacionalidade e NIF)
            String designacao = in.nextLine();
            String nacionalidade = in.nextLine();
            String nif = in.nextLine();
             */
            //NIB, tipo de projecto (Incentivo ou Bonificação), montante de financiamento solicitado, descrição do projecto
            /*
            System.out.println("NIB");
            String nib = br.readLine();
            System.out.println("TIPO");
            String tipo = br.readLine();
            System.out.println("Montante");
            double montante = Double.parseDouble(br.readLine());
            System.out.println("Descricao");
            String descricao = br.readLine();

            /*
            ResponsavelContatoDAO respContatoDAO = new ResponsavelContatoDAO();
            ResponsavelContato rc = new ResponsavelContato();
            rc.setEmail(email);
           
            respContatoDAO.create(rc);
             */
            ProjetoFinanciamentoIncentivo projeto = new ProjetoFinanciamentoIncentivo();
            projeto.setContaBancaria("123");
            projeto.setDataCriacao(new Date());
            projeto.setMontanteFinanciamento(100);

            ProjetoDAO proDAO = new ProjetoDAO();
            proDAO.create(projeto);

        } catch (IOException ex) {
            Logger.getLogger(SgpfImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void parecerTecnico() {
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
    public void alteracaoDadosProjeto() {
    }

    @Override
    public void relatorioInformacaoProjeto() {
    }

    @Override
    public void despachoAberturaProjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void despachoFinanciamento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void despachoReforcoFinanciamento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void realizacaoPagamento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void relatorioPagamentoProjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aberturaprojeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
