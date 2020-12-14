package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.Course;

public interface ICourseDao {

	public Course getCourseById(long id);
	public List<Course> getAllCourses();
	public List<Course> getAllCoursesByLanguagesId(long idLang1, long idLang2);
	public void saveCourse(Course course);
	public void updateCourse(Course course);
	public void deleteCourseById(long id);
	
}
