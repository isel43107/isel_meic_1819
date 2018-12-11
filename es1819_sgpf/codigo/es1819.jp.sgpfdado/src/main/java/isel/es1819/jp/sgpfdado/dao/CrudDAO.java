/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.sgpfdado.dao;

import java.io.Serializable;

/**
 *
 * @author pauloborges
 * @param <T>
 */
public interface CrudDAO <T extends Serializable>{
    
    Long create(T newInstance);
    
    T read(Long id);
    
    void update(T transientObject);
    
    //void delete(T persistentObject);
    
    public void delete(Long id);
}
