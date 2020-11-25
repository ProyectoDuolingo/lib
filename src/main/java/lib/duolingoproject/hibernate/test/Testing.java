package lib.duolingoproject.hibernate.test;

import lib.duolingoproject.hibernate.dao.*;
import lib.duolingoproject.hibernate.dao.i.*;
import lib.duolingoproject.hibernate.model.*;
import lib.duolingoproject.hibernate.model.association.*;

import java.util.ArrayList;
import java.util.List;

public class Testing {

	public static void main(String[] args) {
		
		IUserDao userManager = new UserDaoImpl();
		ICourseTypeDao courseTypeManager = new CourseTypeDaoImpl();
		ICourseDao courseManager = new CourseDaoImpl();
		ILanguageDao languageManager = new LanguageDaoImpl();
		ICategoryDao categoryManager = new CategoryDaoImpl();
		IExerciseTypeDao exerciseTypeManager = new ExerciseTypeDaoImpl();
		IUserCourseDao userCourseManager = new UserCourseDaoImpl();
		Category cat1 = new Category("Food");
		
		ExerciseType et1 = new ExerciseType("match_words");
		
		exerciseTypeManager.saveExerciseType(et1);
		
		CourseType ct1 = new CourseType("Basic");
		
		cat1.addCourseType(ct1);
		
		categoryManager.saveCategory(cat1);
		
		courseTypeManager.saveCourseType(ct1);
		
		Language l1 = new Language("English");
		Language l2 = new Language("Spanish");
		
		languageManager.saveLanguage(l1);
		languageManager.saveLanguage(l2);
		
		Course course1 = new Course(ct1, l1, l2);
		Course course2 = new Course(ct1, l2, l1);
		
		courseManager.saveCourse(course1);
		courseManager.saveCourse(course2);
			
		User u1 = new User("Carlos");
		User u2 = new User("Juanjo");
		User u3 = new User("Pedro");
					
		u1.followUser(u2);
		u2.followUser(u3);
		u3.followUser(u1);
		
		userManager.saveUser(u1);		
		userManager.saveUser(u2);
		userManager.saveUser(u3);
		
		UserCourse userCourse1 = new UserCourse(u1, course2);
		UserCourse userCourse2 = new UserCourse(u2, course1);
		
		u1.addUserCourse(userCourse1);
		u2.addUserCourse(userCourse2);
		
		course2.addUserCourse(userCourse1);
		course1.addUserCourse(userCourse2);
		
		userCourseManager.saveUserCourse(userCourse1);
		userCourseManager.saveUserCourse(userCourse2);
		
		
		
	}

}
