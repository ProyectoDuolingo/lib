package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.CourseType;

public interface ICourseTypeDao {

	public CourseType getCourseTypeById(long id);
	public List<CourseType> getAllCourseTypes();
	public void saveCourseType(CourseType courseType);
	public void updateCourseType(CourseType courseType);
	public void deleteCourseTypeById(long id);
	
}