/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ypmamedia.bookshelf.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Christiaan
 */
@Entity
@Data
@NamedQuery(name=Book.FIND_ALL,query="SELECT b from Book b")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public final static String FIND_ALL = "nl.ypmamedia.bookshelf.business.Book.FIND_ALL";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	 @Size(min=1, max=10)
    private String title;
    
    @ManyToOne
    private Author author;
    
    
}
