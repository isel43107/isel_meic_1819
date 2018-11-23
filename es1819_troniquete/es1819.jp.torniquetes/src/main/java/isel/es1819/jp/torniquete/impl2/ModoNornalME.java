/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.torniquete.impl2;

import isel.es1819.jp.torniquete.impl2.acao.BloquearTrincoAcao;
import isel.es1819.jp.torniquete.impl2.estado.AlarmeEstado;
import isel.es1819.jp.torniquete.impl2.estado.BloqueadoEstado;
import isel.es1819.jp.torniquete.impl2.estado.DesbloqueadoEstado;


/**
 *
 * @author pauloborges
 */
public class ModoNornalME extends MaquinaEstados{
    
    
    public ModoNornalME(Estado estadoIncial) {
        super(estadoIncial, true);
        setTabelaTransicao();
    }
            
    public ModoNornalME() {
        this(new BloqueadoEstado());
    }
    
    private void setTabelaTransicao(){
        
        //Açoes
        Acao acaoBloquearTrinco = new BloquearTrincoAcao();
        
        
        //Estado 
        Estado bloqueado = new BloqueadoEstado();
        Estado desbloqueado = new DesbloqueadoEstado();
        Estado sirene = new AlarmeEstado();
        
        
        
        //BLOQUEADO - para 
        adicionarTransicao(bloqueado, Evento.CARTAO_VALIDO_DETETATO, desbloqueado);
        adicionarTransicao(bloqueado, Evento.PASSAGEM_DETETADA, sirene);
        
        //DESBLOQUEAD - para x
        adicionarTransicao(desbloqueado, Evento.PASSAGEM_DETETADA,bloqueado);
        
        //ALARME -  para x
        adicionarTransicao(sirene, Evento.REINICIAR, bloqueado);
    }
    
}
