package lib.duolingoproject.hibernate.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "category_name", unique = true)
	private String categoryName;
	
	@Column(name = "initial_level")
	private int initialLevel;
	
	@Column(name = "final_level")
	private int finalLevel;
	
	@ManyToMany(mappedBy = "categories")
	private Set<CourseType> courseTypes;
	
	@OneToMany(mappedBy = "category")
	private List<Level> levels;
	
	public Category() {
		
	}
	
	public Category(String categoryName) {
		this.categoryName = categoryName;
		this.initialLevel = 1;
		this.finalLevel = 5;
		this.courseTypes = new HashSet<CourseType>();
		this.levels = new ArrayList<Level>();
		
	}

	public Category(long id, String categoryName, int initialLevel, int finalLevel, Set<CourseType> courseTypes, List<Level> levels) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.initialLevel = initialLevel;
		this.finalLevel = finalLevel;
		this.courseTypes = courseTypes;
		this.levels = levels;
	}
	
	public void addLevel(Level level) {
		
		this.levels.add(level);
		
	}
	
	public void addCourseType(CourseType courseType) {
		
		this.courseTypes.add(courseType);
		
	}
	
	

}
