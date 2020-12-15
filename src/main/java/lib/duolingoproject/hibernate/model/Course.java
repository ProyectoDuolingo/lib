package lib.duolingoproject.hibernate.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@JoinColumn(name = "language_base_id")
	private Language languageBase;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "language_course_id")
	private Language languageCourse;
	
	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	private Set<Category> categories;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Set<UserCourse> courseUsers;
	
	public Course() {
		
		
	}
	
	public Course(Language languageBase, Language languageCourse) {
		
		this.languageBase = languageBase;
		this.languageCourse = languageCourse;
		this.categories = new HashSet<Category>();
		this.courseUsers = new HashSet<UserCourse>();
		
	}
	
	public Course(Language languageBase, Language languageCourse, Set<UserCourse> courseUsers) {
		
		this.languageBase = languageBase;
		this.languageCourse = languageCourse;
		this.courseUsers = courseUsers;
	}	
	
	public void addUserCourse(UserCourse userCourse) {
		
		this.courseUsers.add(userCourse);
		
	}
	
	public void addCategory(Category c) {
		
		this.categories.add(c);
		
	}

	public long getId() {
		return id;
	}

	public Language getLanguageBase() {
		return languageBase;
	}

	public Language getLanguageCourse() {
		return languageCourse;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public Set<UserCourse> getCourseUsers() {
		return courseUsers;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLanguageBase(Language languageBase) {
		this.languageBase = languageBase;
	}

	public void setLanguageCourse(Language languageCourse) {
		this.languageCourse = languageCourse;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public void setCourseUsers(Set<UserCourse> courseUsers) {
		this.courseUsers = courseUsers;
	}
	
	public String toString() {
		
		return languageBase.getLanguageName() + " - " + languageCourse.getLanguageName();
		
	}
	
}
