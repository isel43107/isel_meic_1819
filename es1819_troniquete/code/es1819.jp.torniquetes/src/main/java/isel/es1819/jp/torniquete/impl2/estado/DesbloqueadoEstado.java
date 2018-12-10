/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.torniquete.impl2.estado;

import isel.es1819.jp.torniquete.impl2.Acao;
import isel.es1819.jp.torniquete.impl2.Estado;
import isel.es1819.jp.torniquete.impl2.acao.DesbloquearTrincoAcao;

/**
 *
 * @author pauloborges
 */
public class DesbloqueadoEstado extends Estado{
    
    public DesbloqueadoEstado(){
        this(new DesbloquearTrincoAcao(), null);
    }
    public DesbloqueadoEstado(Acao acaoEntrada, Acao acaoSaida) {
        super(acaoEntrada, acaoSaida);
    }
    
}
