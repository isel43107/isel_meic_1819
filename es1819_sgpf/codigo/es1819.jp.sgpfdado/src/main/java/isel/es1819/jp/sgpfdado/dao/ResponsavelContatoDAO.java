/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.sgpfdado.dao;

import isel.es1819.jp.sgpfdado.ResponsavelContato;

/**
 *
 * @author pauloborges
 */
public class ResponsavelContatoDAO extends BaseCrudDAO<ResponsavelContato>{

    @Override
    protected Class<ResponsavelContato> getEntityClass() {
        return ResponsavelContato.class; 
    }
    
}
