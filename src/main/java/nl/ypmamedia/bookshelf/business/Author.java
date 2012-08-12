/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ypmamedia.bookshelf.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author Christiaan
 */
@Entity @Data
public class Author implements Serializable {
    
      @Id
    private Long id;
    
    private String name;
  

   
    
}
