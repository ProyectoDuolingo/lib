package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.ICourseDao;
import lib.duolingoproject.hibernate.model.Course;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class CourseDaoImpl implements ICourseDao{
	
	// saveCourse
	// getAllCourses
	// getCourseById
	// updateCourse
	// deleteCourseById
	
	public Course getCourseById(long id) {
		
		Transaction transaction = null;
		
		Course course = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get Course object
			
			course = session.get(Course.class, id);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return course;
		
	}
	
	public List<Course> getAllCourses() {
		
		Transaction transaction = null;
		
		List<Course> coursesList = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get Courses list
			coursesList = session.createQuery("from Course").list();
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return coursesList;
		
	}
	
	public void saveCourse(Course course) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save Course object
			
			session.save(course);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateCourse(Course course) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save Course object
			
			session.saveOrUpdate(course);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteCourseById(long id) {
		
		Transaction transaction = null;
		
		Course course = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get Course object
			course = session.get(Course.class, id);
			
			// Delete Course object
			session.delete(course);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
