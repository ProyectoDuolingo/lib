package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.IExerciseTypeDao;
import lib.duolingoproject.hibernate.model.ExerciseType;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class ExerciseTypeDaoImpl implements IExerciseTypeDao{
	
	// saveExerciseType
	// getAllExerciseTypes
	// getExerciseTypeById
	// updateExerciseType
	// deleteExerciseTypeById
	
	public ExerciseType getExerciseTypeById(long id) {
		
		Transaction transaction = null;
		
		ExerciseType exerciseType = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseType object
			
			exerciseType = session.get(ExerciseType.class, id);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return exerciseType;
		
	}
	
	public List<ExerciseType> getAllExercisesType() {
		
		Transaction transaction = null;
		
		List<ExerciseType> exercisesTypeList = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseType list
			exercisesTypeList = session.createQuery("from exercise_type").list();
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return exercisesTypeList;
		
	}
	
	public void saveExerciseType(ExerciseType exerciseType) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save ExerciseType object
			
			session.save(exerciseType);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateExerciseType(ExerciseType exerciseType) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save ExerciseType object
			
			session.saveOrUpdate(exerciseType);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteExerciseTypeById(long id) {
		
		Transaction transaction = null;
		
		ExerciseType exerciseType = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseType object
			exerciseType = session.get(ExerciseType.class, id);
			
			// Delete ExerciseType object
			session.delete(exerciseType);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
