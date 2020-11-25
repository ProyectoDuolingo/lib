package lib.duolingoproject.hibernate.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lib.duolingoproject.hibernate.model.association.UserCourse;

@Entity
@Table(name =  "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "course_type_id")
	private CourseType courseType;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "language_base_id")
	private Language languageBase;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "language_course_id")
	private Language languageCourse;
	
	@OneToMany(mappedBy = "user")
	private Set<UserCourse> courseUsers;
	
	public Course() {
		
		
	}
	
	public Course(CourseType courseType, Language languageBase, Language languageCourse) {
		
		this.courseType = courseType;
		this.languageBase = languageBase;
		this.languageCourse = languageCourse;
		this.courseUsers = new HashSet<UserCourse>();
		
	}
	
	public Course(long id, CourseType courseType, Language languageBase, Language languageCourse, Set<UserCourse> courseUsers) {
		
		this.id = id;
		this.courseType = courseType;
		this.languageBase = languageBase;
		this.languageCourse = languageCourse;
		this.courseUsers = courseUsers;
	}	
	
	public void addUserCourse(UserCourse userCourse) {
		
		this.courseUsers.add(userCourse);
		
	}
	
}
