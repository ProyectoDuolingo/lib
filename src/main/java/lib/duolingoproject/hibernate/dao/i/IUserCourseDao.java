package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.association.UserCourse;

public interface IUserCourseDao {
	
	public UserCourse getUserCourseById(long userId, long courseId);
	public List<UserCourse> getAllUserCoursesById(long userId);
	public void saveUserCourse(UserCourse userCourse);
	public void updateUserCourse(UserCourse userCourse);
	public void deleteUserCourseById(long userId, long courseId);

}
