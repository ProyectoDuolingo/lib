package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.IExerciseReorderWordsDao;
import lib.duolingoproject.hibernate.model.ExerciseReorderWords;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class ExerciseReorderWordsDaoImpl implements IExerciseReorderWordsDao{
	
	// saveExerciseReorderWords
	// getAllExerciseReorderWordss
	// getExerciseReorderWordsById
	// updateExerciseReorderWords
	// deleteExerciseReorderWordsById
	
	public ExerciseReorderWords getExerciseReorderWordsById(long id) {
		
		Transaction transaction = null;
		
		ExerciseReorderWords exerciseReorderWords = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseReorderWords object
			
			exerciseReorderWords = session.get(ExerciseReorderWords.class, id);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return exerciseReorderWords;
		
	}
	
	public List<ExerciseReorderWords> getAllExercisesReorderWords() {
		
		Transaction transaction = null;
		
		List<ExerciseReorderWords> exercisesReorderWordsList = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseReorderWords list
			exercisesReorderWordsList = session.createQuery("from exercise_reorder_words").list();
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return exercisesReorderWordsList;
		
	}
	
	public void saveExerciseReorderWords(ExerciseReorderWords exerciseReorderWords) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save ExerciseReorderWords object
			
			session.save(exerciseReorderWords);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateExerciseReorderWords(ExerciseReorderWords exerciseReorderWords) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save ExerciseReorderWords object
			
			session.saveOrUpdate(exerciseReorderWords);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteExerciseReorderWordsById(long id) {
		
		Transaction transaction = null;
		
		ExerciseReorderWords exerciseReorderWords = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseReorderWords object
			exerciseReorderWords = session.get(ExerciseReorderWords.class, id);
			
			// Delete ExerciseReorderWords object
			session.delete(exerciseReorderWords);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
