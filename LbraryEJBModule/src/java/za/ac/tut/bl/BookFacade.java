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
import za.ac.tut.enttes.Book;

/**
 *
 * @author Wonder
 */
@Stateless
public class BookFacade extends AbstractFacade<Book> implements BookFacadeLocal {

    @PersistenceContext(unitName = "LbraryEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookFacade() {
        super(Book.class);
    }

    @Override
    public List<Book> findByTitle(String title) {
        Query q = em.createQuery("SELECT b FROM Book b WHERE b.title = :title");
        q.setParameter("title", title);
        List<Book> books = q.getResultList();
        return books;
    }
    
}
