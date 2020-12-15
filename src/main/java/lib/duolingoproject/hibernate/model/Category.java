package lib.duolingoproject.hibernate.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<Level> levels;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	public Category() {
		
	}
	
	public Category(long id, String categoryName, int initialLevel, int finalLevel, List<Level> levels, Course course) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.initialLevel = initialLevel;
		this.finalLevel = finalLevel;
		this.levels = levels;
		this.course = course;
	}



	public Category(String categoryName, Course course) {
		this.categoryName = categoryName;
		this.initialLevel = 1;
		this.finalLevel = 5;
		this.levels = new ArrayList<Level>();
		this.course = course;
		
	}
	
	public void addLevel(Level level) {
		
		this.levels.add(level);
		
	}

	public long getId() {
		return id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public int getInitialLevel() {
		return initialLevel;
	}

	public int getFinalLevel() {
		return finalLevel;
	}

	public List<Level> getLevels() {
		return levels;
	}

	public Course getCourse() {
		return course;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setInitialLevel(int initialLevel) {
		this.initialLevel = initialLevel;
	}

	public void setFinalLevel(int finalLevel) {
		this.finalLevel = finalLevel;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}

	public void setCourse(Course course) {
		this.course = course;
	}	
	
	public String toString() {
		
		return categoryName;
		
	}

}
