/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.sgpfdado.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Provides singleton access to the {@link EntityManagerFactory}.
 *
 * @author Pborges
 */
public class PersistenceUtils {

    private volatile static PersistenceUtils INSTANCE;
    public static final String PERSISTENCE_UNIT_ECLIP_PROD = "SGPF_PU";

    private EntityManagerFactory emf;

    private PersistenceUtils() {
        emf = createEntityManagerFactory();
    }


    private EntityManagerFactory createEntityManagerFactory() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_ECLIP_PROD);
    }

    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public void close() {
        if (emf != null) {
            emf.close();
            emf = null;
        }
    }
    
    /**
     * The {@link EntityManagerFactory} is created the first time this method id
     * called.
     *
     * @return EntityManagerFactory
     */
    public EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = createEntityManagerFactory();
        }
        return emf;
    }

    /**
     * Returns the singleton instance of PersistenceHelper.
     *
     * @return the persistence helper instance
     */
    public static PersistenceUtils getInstance() {
        PersistenceUtils _INSTANCE = PersistenceUtils.INSTANCE;
        if (_INSTANCE == null) {
            synchronized (PersistenceUtils.class) {
                _INSTANCE = PersistenceUtils.INSTANCE;
                if (_INSTANCE == null) {
                    PersistenceUtils.INSTANCE = _INSTANCE = new PersistenceUtils();
                }
            }
        }
        return _INSTANCE;
    }
    // </editor-fold>
}
