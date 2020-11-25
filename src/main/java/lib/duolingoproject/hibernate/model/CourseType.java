package lib.duolingoproject.hibernate.model;

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
@Table(name =  "course_type")
public class CourseType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "course_typename", unique = true)
	private String courseTypeName;
	
	@OneToMany(mappedBy = "courseType")
	private List<Course> courses;
	
	@ManyToMany
	@JoinTable(
		name = "course_type_category",
		joinColumns = { @JoinColumn(name = "course_type_id") },
		inverseJoinColumns = { @JoinColumn(name = "category_id") }
	)	
	private Set<Category> categories;
	
	public CourseType() {
		
		
		
	}
	
	public CourseType(String courseTypeName) {
		
		this.courseTypeName = courseTypeName;
		
	}

	public CourseType(long id, String courseTypeName, List<Course> courses, Set<Category> categories) {
		
		this.id = id;
		this.courseTypeName = courseTypeName;
		this.courses = courses;
		this.categories = categories;
	}	
	
	public void addCourse(Course course) {
		
		this.courses.add(course);
		
	}

}
