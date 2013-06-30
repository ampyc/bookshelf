/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ypmamedia.bookshelf.presentation;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import nl.ypmamedia.bookshelf.business.Book;
import nl.ypmamedia.bookshelf.business.BookService;

/**
 *
 * @author Christiaan
 */
@Named
@ConversationScoped
public class Index implements Serializable{
    
    @EJB
    BookService bookService;
	 
	 @Inject
	 Conversation conversation;
    
	 @Getter
    private Book book;
	 
	 @Getter @Setter
	 private Long bookId;
    
    public Index(){
        book = new Book();
    }
    
	 public void retrieve(){	
		 conversation.begin();
		 if (bookId != null){
			 book = bookService.findBookById(bookId);
		 }
	}
	 
    public List<Book> getBooks(){
        return bookService.getBooks();
    }
    
    public void save(){
        bookService.save(book);
		  conversation.end();
    }
	 
	 public String cancel(){
		  book = new Book();
		  conversation.end();
		  return "index";
    }
    
    
}
