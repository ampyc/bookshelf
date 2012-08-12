/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ypmamedia.bookshelf.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Christiaan
 */
@Stateless
public class BookService {
    @PersistenceContext
    EntityManager em;
    
    public void save(Book book){
        em.persist(book);
    }
    
    public List<Book> getBooks(){
        return em.createNamedQuery(Book.FIND_ALL).getResultList();
    }
}
