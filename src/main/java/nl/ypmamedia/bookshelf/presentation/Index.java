/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ypmamedia.bookshelf.presentation;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import lombok.Getter;
import nl.ypmamedia.bookshelf.business.Book;
import nl.ypmamedia.bookshelf.business.BookService;

/**
 *
 * @author Christiaan
 */
@Model
public class Index {
    
    @EJB
    BookService bookService;
    
    @Getter
    private Book book;
    
    public Index(){
        this.book = new Book();
    }
    
    public List<Book> getBooks(){
        return bookService.getBooks();
    }
    
    public void save(){
        bookService.save(book);
    }
    
    
}
