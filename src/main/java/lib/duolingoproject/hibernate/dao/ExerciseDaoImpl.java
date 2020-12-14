package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.IExerciseDao;
import lib.duolingoproject.hibernate.model.Exercise;
import lib.duolingoproject.hibernate.model.ExerciseTest;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class ExerciseDaoImpl implements IExerciseDao{
	
	// saveExerciseCompleteWord
	// getAllExerciseCompleteWords
	// getExerciseCompleteWordById
	// updateExerciseCompleteWord
	// deleteExerciseCompleteWordById
	
	public List<Exercise> getExercisesByLevelIdAndTypeId(long idLevel, long idType) {
	
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				
			List<Exercise> exercises = session.createSQLQuery("select * from exercise where category_id = " + idLevel + " and exercise_type_id = " + idType).addEntity(Exercise.class).list();
					
			return exercises;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return null;
			
		}
		
	}
	
	public List<Exercise> getAllExercisesByLevelId(long idLevel) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			List<Exercise> exercises = session.createSQLQuery("select * from exercise where category_id = " + idLevel).addEntity(Exercise.class).list();
					
			return exercises;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return null;
			
		}
		
	}
	
	public void saveExercise(Exercise exercise) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save ExerciseCompleteWord object
			
			session.save(exercise);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateExercise(Exercise exercise) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save ExerciseCompleteWord object
			
			session.saveOrUpdate(exercise);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteExerciseById(long id) {
		
		Transaction transaction = null;
		
		Exercise exercise = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseCompleteWord object
			exercise = session.get(Exercise.class, id);
			
			// Delete ExerciseCompleteWord object
			session.delete(exercise);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
