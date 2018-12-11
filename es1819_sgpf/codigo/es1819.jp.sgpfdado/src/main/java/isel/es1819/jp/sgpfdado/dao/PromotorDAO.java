/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.sgpfdado.dao;

import isel.es1819.jp.sgpfdado.Promotor;

/**
 *
 * @author pauloborges
 */
public class PromotorDAO extends BaseCrudDAO<Promotor>{

    @Override
    protected Class<Promotor> getEntityClass() {
        return Promotor.class; 
    }
    
}
