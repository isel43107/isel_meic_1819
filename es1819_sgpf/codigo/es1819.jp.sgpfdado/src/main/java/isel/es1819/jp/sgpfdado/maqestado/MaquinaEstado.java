/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.sgpfdado.maqestado;

/**
 *
 * @author pauloborges
 */
public class MaquinaEstado {
    
    /**
     * ()
     */
    private Evento evento;
    private Estado estadoAtual;
    private Estado estadoProximo;
    

    enum Estado {
        NONE,
        CANDIDATURA,
        ABERTO,
        ANALISE_TECNICA,
        DESPACHO_FINANCIAMENTO,
        PAGEMENTO,
        FECHADO,
        REFORCO,
        ARQUIVADO
    }
    
    
    enum Evento {
        PROJETO_ENQUADRA,
        PROJETO_NAO_ENQUADRA,
        DESPACHO_ABERTURA_APROVADO,
        DESPACHO_ABERTURA_REJEITADO,
        PARECER_TECNICO_FAVORAVEL,
        PARECER_TECNICO_NAO_FAVORAVEL,
        DESPACHO_FINANCIAMENTO_APROVADO, 
        DESPACHO_FINANCIAMENTO_REJEITADO,
        DESPACHO_FINANCIAMENTO_TRANFORMAR_BONIFICACAO,
        REALIZAR_REFORCO,
        DEPACHO_REFORCO_APROVADO,
        DEPACHO_REFORCO_REJEITADO;
    }
    
    
    enum Acao {
    
    
    }
}
