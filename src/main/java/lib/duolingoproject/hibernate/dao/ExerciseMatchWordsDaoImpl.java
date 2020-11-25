package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.IExerciseMatchWordsDao;
import lib.duolingoproject.hibernate.model.ExerciseMatchWords;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class ExerciseMatchWordsDaoImpl implements IExerciseMatchWordsDao{
	
	// saveExerciseMatchWords
	// getAllExerciseMatchWordss
	// getExerciseMatchWordsById
	// updateExerciseMatchWords
	// deleteExerciseMatchWordsById
	
	public ExerciseMatchWords getExerciseMatchWordsById(long id) {
		
		Transaction transaction = null;
		
		ExerciseMatchWords exerciseMatchWords = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseMatchWords object
			
			exerciseMatchWords = session.get(ExerciseMatchWords.class, id);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return exerciseMatchWords;
		
	}
	
	public List<ExerciseMatchWords> getAllExercisesMatchWords() {
		
		Transaction transaction = null;
		
		List<ExerciseMatchWords> exercisesMatchWordssList = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseMatchWordss list
			exercisesMatchWordssList = session.createQuery("from exercise_match_words").list();
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return exercisesMatchWordssList;
		
	}
	
	public void saveExerciseMatchWords(ExerciseMatchWords exerciseMatchWords) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save ExerciseMatchWords object
			
			session.save(exerciseMatchWords);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateExerciseMatchWords(ExerciseMatchWords exerciseMatchWords) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save ExerciseMatchWords object
			
			session.saveOrUpdate(exerciseMatchWords);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteExerciseMatchWordsById(long id) {
		
		Transaction transaction = null;
		
		ExerciseMatchWords exerciseMatchWords = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseMatchWords object
			exerciseMatchWords = session.get(ExerciseMatchWords.class, id);
			
			// Delete ExerciseMatchWords object
			session.delete(exerciseMatchWords);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
