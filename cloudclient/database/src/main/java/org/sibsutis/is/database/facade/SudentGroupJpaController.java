/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package org.sibsutis.is.database.facade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import org.sibsutis.is.database.facade.exceptions.NonexistentEntityException;
import org.sibsutis.is.database.model.entity.SudentGroup;

/**

 @author Admin
 */
public class SudentGroupJpaController implements Serializable
{

    public SudentGroupJpaController(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public void create(SudentGroup sudentGroup)
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sudentGroup);
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void edit(SudentGroup sudentGroup) throws NonexistentEntityException, Exception
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            sudentGroup = em.merge(sudentGroup);
            em.getTransaction().commit();
        }
        catch (Exception ex)
        {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0)
            {
                Long id = sudentGroup.getId();
                if (findSudentGroup(id) == null)
                {
                    throw new NonexistentEntityException("The sudentGroup with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            SudentGroup sudentGroup;
            try
            {
                sudentGroup = em.getReference(SudentGroup.class, id);
                sudentGroup.getId();
            }
            catch (EntityNotFoundException enfe)
            {
                throw new NonexistentEntityException("The sudentGroup with id " + id + " no longer exists.", enfe);
            }
            em.remove(sudentGroup);
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public List<SudentGroup> findSudentGroupEntities()
    {
        return findSudentGroupEntities(true, -1, -1);
    }

    public List<SudentGroup> findSudentGroupEntities(int maxResults, int firstResult)
    {
        return findSudentGroupEntities(false, maxResults, firstResult);
    }

    private List<SudentGroup> findSudentGroupEntities(boolean all, int maxResults, int firstResult)
    {
        EntityManager em = getEntityManager();
        try
        {
            Query q = em.createQuery("select object(o) from SudentGroup as o");
            if (!all)
            {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        }
        finally
        {
            em.close();
        }
    }

    public SudentGroup findSudentGroup(Long id)
    {
        EntityManager em = getEntityManager();
        try
        {
            return em.find(SudentGroup.class, id);
        }
        finally
        {
            em.close();
        }
    }

    public int getSudentGroupCount()
    {
        EntityManager em = getEntityManager();
        try
        {
            Query q = em.createQuery("select count(o) from SudentGroup as o");
            return ((Long) q.getSingleResult()).intValue();
        }
        finally
        {
            em.close();
        }
    }
    
}
