package lib.duolingoproject.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int _id;
	
	@Column(name = "category_name")
	private String _categoryName;
	
	@Column(name = "initial_level")
	private int _initialLevel;
	
	@Column(name = "final_level")
	private int _finalLevel;

}
