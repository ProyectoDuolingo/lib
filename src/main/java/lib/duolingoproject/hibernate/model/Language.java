package lib.duolingoproject.hibernate.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name =  "language")
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "language_name", unique = true)
	private String languageName;
	
	@Column(name = "code", unique = true)
	private String code;

	public Language() {
		super();
	}

	public Language(String languageName) {
		
		this.languageName = languageName;
	}
	
	
		
}
