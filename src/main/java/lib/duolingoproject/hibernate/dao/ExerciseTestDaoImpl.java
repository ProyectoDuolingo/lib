package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.IExerciseTestDao;
import lib.duolingoproject.hibernate.model.ExerciseTest;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class ExerciseTestDaoImpl implements IExerciseTestDao{
	
	// saveExerciseTest
	// getAllExerciseTests
	// getExerciseTestById
	// updateExerciseTest
	// deleteExerciseTestById
	
	public ExerciseTest getExerciseTestById(long id) {
		
		Transaction transaction = null;
		
		ExerciseTest exerciseTest = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseTest object
			
			exerciseTest = session.get(ExerciseTest.class, id);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return exerciseTest;
		
	}
	
	public List<ExerciseTest> getAllExercisesTest() {
		
		Transaction transaction = null;
		
		List<ExerciseTest> exercisesTestList = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseTest list
			exercisesTestList = session.createQuery("from exercise_test").list();
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return exercisesTestList;
		
	}
	
	public void saveExerciseTest(ExerciseTest exerciseTest) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save ExerciseTest object
			
			session.save(exerciseTest);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateExerciseTest(ExerciseTest exerciseTest) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save ExerciseTest object
			
			session.saveOrUpdate(exerciseTest);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteExerciseTestById(long id) {
		
		Transaction transaction = null;
		
		ExerciseTest exerciseTest = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseTest object
			exerciseTest = session.get(ExerciseTest.class, id);
			
			// Delete ExerciseTest object
			session.delete(exerciseTest);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
