/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.sgpfdado.dao;

import isel.es1819.jp.sgpfdado.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author pauloborges
 * @param <ENTITY>
 */
public abstract class BaseCrudDAO<ENTITY extends BaseEntity> implements CrudDAO<ENTITY>{

    protected static final Logger LOGGER = Logger.getLogger(BaseCrudDAO.class.getName());
    private EntityManagerFactory entityManagerFactory;

    protected abstract Class<ENTITY> getEntityClass();
    
    private String getEntityName(){
        return getEntityClass().getSimpleName();
    }
    
    protected EntityManagerFactory getEntityManagerFactory(){
        return this.entityManagerFactory;
    }
    
    public BaseCrudDAO() {
        this(PersistenceUtils.getInstance().getEntityManagerFactory());
    }
    
    public BaseCrudDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    
    
    @Override
    public Long create(ENTITY newInstance) {
        EntityManager em = null;

        try {
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            em.persist(newInstance);
            em.flush(); // ID Available
            em.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Excecao ao persistir/criar a entidade ("+getEntityName()+")", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return newInstance.getId();
    }

    @Override
    public ENTITY read(Long id) {
        
        //String sql = String.format("SELECT entity FROM %s entity WHERE entity.id = :id", getEntityName());
        EntityManager em = null;
        ENTITY entidade = null;
        try {
            em = entityManagerFactory.createEntityManager();
            entidade = em.find(getEntityClass(), id);

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Excecao ao select ("+getEntityName()+")", ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return entidade;
    }

    @Override
    public void update(ENTITY entity) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean result = false;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(entity);
            entityTransaction.commit();
            result = true;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Excecao ao atualizar uma entidade ("+getEntityName()+") com id: " + entity.getId(), ex);
            result = false;
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    //@Override
    public void delete(ENTITY persistentObject) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //@Override
    public int count() {
        String sql = String.format("SELECT COUNT(r) FROM %s r", getEntityName());
        EntityManager em = null;
        int count = 0;
        try {
            em = entityManagerFactory.createEntityManager();

            Query q = em.createQuery(sql);
            count =  ((Number) q.getSingleResult()).intValue();

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Excecao ao contar ("+getEntityName()+")", ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return count;
    }
    
    @Override
    public void delete(Long id) {
        String sql = String.format("DELETE FROM %s entity WHERE entity.id=:id", getEntityName());
        EntityManager em = null;
        boolean result = false;
        try {
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery(sql);
            int deletedCount = query.setParameter("id", id).executeUpdate();
            if (deletedCount > 0) {
                result = true;
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Excecao ao delete ("+getEntityName()+") com id: " + id, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //@Override
    public List<ENTITY> findRange(int offset, int limit) {
        return findRange(offset, limit, false);
    }

    //@Override
    public List<ENTITY> findAll() {
        List<ENTITY> entityList = new ArrayList<>();

        String sql = String.format("SELECT e FROM %s e", getEntityName());
        EntityManager em = null;
        try {
            em = entityManagerFactory.createEntityManager();

            entityList = em.createQuery(sql, getEntityClass())
                    .getResultList();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Excecao executar findAll ("+getEntityName()+")", ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return entityList;
    }
    
    public List<ENTITY> findRange(int offset, int limit, boolean descendingOrder) {

        List<ENTITY> entityList = new ArrayList<>();
        EntityManager em = null;
        try {
            em = getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<ENTITY> c = cq.from(getEntityClass());
            cq.select(cq.from(getEntityClass()));
            if (descendingOrder) {
                cq.orderBy(cb.desc(c.get("id")));
            } else {
                cq.orderBy(cb.asc(c.get("id")));
            }

            Query q = em.createQuery(cq);
            q.setMaxResults(limit);
            q.setFirstResult(offset);
            entityList = q.getResultList();

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Excecao ao executar findRange ("
                    + getEntityName() + ") in range (" + offset + ", " + limit + ")", ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return entityList;
    }

}
