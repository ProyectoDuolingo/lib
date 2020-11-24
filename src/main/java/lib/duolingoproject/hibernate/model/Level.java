package lib.duolingoproject.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "level")
public class Level {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Segun el rango de su Category
	@Column(name = "id")
	private int _id;
	
	private Category _category;

}
