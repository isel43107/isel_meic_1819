/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.torniquete.impl2.acao;

import isel.es1819.jp.torniquete.impl2.Acao;

/**
 *
 * @author pauloborges
 */
public class ActivarSireneAcao implements Acao{

    @Override
    public void execucao() {
        System.out.println("Sirene ACTIVADA");
    }
    
}