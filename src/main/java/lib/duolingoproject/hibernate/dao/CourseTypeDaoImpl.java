package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.ICourseTypeDao;
import lib.duolingoproject.hibernate.model.CourseType;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class CourseTypeDaoImpl implements ICourseTypeDao{
	
	// saveCourseType
	// getAllCourseTypes
	// getCourseTypeById
	// updateCourseType
	// deleteCourseTypeById
	
	public CourseType getCourseTypeById(long id) {
		
		Transaction transaction = null;
		
		CourseType courseType = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get CourseType object
			
			courseType = session.get(CourseType.class, id);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return courseType;
		
	}
	
	public List<CourseType> getAllCourseTypes() {
		
		Transaction transaction = null;
		
		List<CourseType> courseTypesList = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get CourseTypes list
			courseTypesList = session.createQuery("from course_type").list();
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return courseTypesList;
		
	}
	
	public void saveCourseType(CourseType courseType) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save CourseType object
			
			session.save(courseType);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateCourseType(CourseType courseType) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save CourseType object
			
			session.saveOrUpdate(courseType);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteCourseTypeById(long id) {
		
		Transaction transaction = null;
		
		CourseType courseType = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get CourseType object
			courseType = session.get(CourseType.class, id);
			
			// Delete CourseType object
			session.delete(courseType);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
