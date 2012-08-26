package nl.ypmamedia.bookshelf.business;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;

import lombok.Data;

@Entity
@Data
public class Author implements Serializable {
	@Id
	private @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	Long id = null;

	@Version
	private @Column(name = "version")
	int version = 0;

	@Column
	private String name;
	
	public String toString(){
		return name;
	}
}