/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ypmamedia.bookshelf.business;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
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
    
    @Version
	@Column(name = "version")
    private int version = 0;
    
	 @Size(min=1, max=255)
	 @NotNull
    private String title;
    
    @ManyToOne
    private Author author;
    
	@ManyToOne
	private Member owner;

	@ManyToOne
	private Member locatedAt;
	
	public String toString(){
		return author + " - " + title;
	}
    
    
}
