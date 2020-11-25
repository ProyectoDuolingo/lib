package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.IUserCourseDao;
import lib.duolingoproject.hibernate.model.User;
import lib.duolingoproject.hibernate.model.association.UserCourse;
import lib.duolingoproject.hibernate.model.association.UserCourse.UserCourseId;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class UserCourseDaoImpl implements IUserCourseDao{
	
	// saveUserCourse
	// getAllUserCourses
	// getUserCourseById
	// updateUserCourse
	// deleteUserCourseById
	
	public UserCourse getUserCourseById(long userId, long courseId) {
		
		Transaction transaction = null;
		
		UserCourse userCourse = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get UserCourse object
		
			userCourse = session.get(UserCourse.class, userCourse.new UserCourseId(userId, courseId));
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return userCourse;
		
	}
	
	public List<UserCourse> getAllUserCoursesById(long userId) {
		
		Transaction transaction = null;
		
		List<UserCourse> userCoursesList = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get UserCourses list
			userCoursesList = session.createQuery("from user_course where user_id = '" + userId + "'").list();
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return userCoursesList;
		
	}
	
	public void saveUserCourse(UserCourse userCourse) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save UserCourse object
			
			session.save(userCourse);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateUserCourse(UserCourse userCourse) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save UserCourse object
			
			session.saveOrUpdate(userCourse);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteUserCourseById(long userId, long courseId) {
		
		Transaction transaction = null;
		
		UserCourse userCourse = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get UserCourse object
			userCourse = session.get(UserCourse.class, userCourse.new UserCourseId(userId, courseId));
			
			// Delete UserCourse object
			session.delete(userCourse);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
