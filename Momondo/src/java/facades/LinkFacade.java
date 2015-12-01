/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import deploy.DeploymentConfiguration;
import entity.Link;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Sindt
 */
public class LinkFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);

    public LinkFacade() {
    }

    public Link addLink(Link l) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }

        return l;
    }

    public Link getLink(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Link l = em.find(Link.class, id);
            return l;
        } finally {
            em.close();
        }

    }

    public List<Link> getAllLinks() {
        EntityManager em = emf.createEntityManager();
        Query q;
        try {
            q = em.createNamedQuery("Link.findAll", Link.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

}
