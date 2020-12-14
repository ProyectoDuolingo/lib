package lib.duolingoproject.hibernate.test;

import lib.duolingoproject.hibernate.dao.*;
import lib.duolingoproject.hibernate.dao.i.*;
import lib.duolingoproject.hibernate.model.*;
import lib.duolingoproject.hibernate.model.association.*;

import java.util.ArrayList;
import java.util.List;

public class Testing {

	public static void main(String[] args) {
		
		List<Language> languagesList = new ArrayList<Language>();
		ILanguageDao languageManager = new LanguageDaoImpl();
//		IUserDao userManager = new UserDaoImpl();
//		ICourseDao courseManager = new CourseDaoImpl();
//		ICategoryDao categoryManager = new CategoryDaoImpl();
//		IExerciseTypeDao exerciseTypeManager = new ExerciseTypeDaoImpl();
//		IUserCourseDao userCourseManager = new UserCourseDaoImpl();
//		
//		ExerciseType et1 = new ExerciseType("match_words");
//		
//		exerciseTypeManager.saveExerciseType(et1);
//			
//		User u1 = new User("Carlos");
//		User u2 = new User("Juanjo");
//		User u3 = new User("Pedro");
//					
//		u1.followUser(u2);
//		u2.followUser(u3);
//		u3.followUser(u1);
//		
//		userManager.saveUser(u1);		
//		userManager.saveUser(u2);
//		userManager.saveUser(u3);		
		
		languagesList = languageManager.getAllLanguages();
		
		for (Language l : languagesList) {
			
			System.out.println(l.getLanguageName());
			
		}
		
	}

}
