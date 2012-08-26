package nl.ypmamedia.bookshelf.business;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;

import lombok.Data;

@Entity
@Data
public class Member implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id = null;

	@Version
	@Column(name = "version")
	private int version = 0;

	@Column
	private String name;
	
	public String toString(){
		return name;
	}
}