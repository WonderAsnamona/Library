/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.enttes.Client;

/**
 *
 * @author Wonder
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

    @PersistenceContext(unitName = "LbraryEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public Client findByUsernameAndPassword(String username, String password) {
        Query q = em.createQuery("SELECT c FROM Client c WHERE c.username = :username AND c.password = :password");
        q.setParameter("username", username);
        q.setParameter("password", password);
        Client c = null;
        List<Client> cs = q.getResultList();
        if(cs != null && !cs.isEmpty()){
            c = cs.get(0);
        }
        return c;    
    }

    @Override
    public Client findByUsername(String username) {
        Query q = em.createQuery("SELECT c FROM Client c WHERE c.username = :username");
        q.setParameter("username", username);
        Client c = null;
        List<Client> cs = q.getResultList();
        if(cs != null && !cs.isEmpty()){
            c = cs.get(0);
        }
        return c;
    }
    
}
