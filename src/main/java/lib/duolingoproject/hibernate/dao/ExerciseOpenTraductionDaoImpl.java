package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.IExerciseOpenTraductionDao;
import lib.duolingoproject.hibernate.model.ExerciseOpenTraduction;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class ExerciseOpenTraductionDaoImpl implements IExerciseOpenTraductionDao{
	
	// saveExerciseOpenTraduction
	// getAllExerciseOpenTraductions
	// getExerciseOpenTraductionById
	// updateExerciseOpenTraduction
	// deleteExerciseOpenTraductionById
	
	public ExerciseOpenTraduction getExerciseOpenTraductionById(long id) {
		
		Transaction transaction = null;
		
		ExerciseOpenTraduction exerciseOpenTraduction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseOpenTraduction object
			
			exerciseOpenTraduction = session.get(ExerciseOpenTraduction.class, id);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return exerciseOpenTraduction;
		
	}
	
	public List<ExerciseOpenTraduction> getAllExercisesOpenTraduction() {
		
		Transaction transaction = null;
		
		List<ExerciseOpenTraduction> exercisesOpenTraductionsList = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseOpenTraductions list
			exercisesOpenTraductionsList = session.createQuery("from exercise_open_traduction").list();
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return exercisesOpenTraductionsList;
		
	}
	
	public void saveExerciseOpenTraduction(ExerciseOpenTraduction exerciseOpenTraduction) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save ExerciseOpenTraduction object
			
			session.save(exerciseOpenTraduction);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateExerciseOpenTraduction(ExerciseOpenTraduction exerciseOpenTraduction) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save ExerciseOpenTraduction object
			
			session.saveOrUpdate(exerciseOpenTraduction);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteExerciseOpenTraductionById(long id) {
		
		Transaction transaction = null;
		
		ExerciseOpenTraduction exerciseOpenTraduction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseOpenTraduction object
			exerciseOpenTraduction = session.get(ExerciseOpenTraduction.class, id);
			
			// Delete ExerciseOpenTraduction object
			session.delete(exerciseOpenTraduction);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
