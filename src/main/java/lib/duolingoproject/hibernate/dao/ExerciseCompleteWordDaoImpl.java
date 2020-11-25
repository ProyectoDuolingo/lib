package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.IExerciseCompleteWordDao;
import lib.duolingoproject.hibernate.model.ExerciseCompleteWord;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class ExerciseCompleteWordDaoImpl implements IExerciseCompleteWordDao{
	
	// saveExerciseCompleteWord
	// getAllExerciseCompleteWords
	// getExerciseCompleteWordById
	// updateExerciseCompleteWord
	// deleteExerciseCompleteWordById
	
	public ExerciseCompleteWord getExerciseCompleteWordById(long id) {
		
		Transaction transaction = null;
		
		ExerciseCompleteWord exerciseCompleteWord = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseCompleteWord object
			
			exerciseCompleteWord = session.get(ExerciseCompleteWord.class, id);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return exerciseCompleteWord;
		
	}
	
	public List<ExerciseCompleteWord> getAllExercisesCompleteWord() {
		
		Transaction transaction = null;
		
		List<ExerciseCompleteWord> exercisesCompleteWordsList = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseCompleteWords list
			exercisesCompleteWordsList = session.createQuery("from exercise_complete_word").list();
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return exercisesCompleteWordsList;
		
	}
	
	public void saveExerciseCompleteWord(ExerciseCompleteWord exerciseCompleteWord) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save ExerciseCompleteWord object
			
			session.save(exerciseCompleteWord);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateExerciseCompleteWord(ExerciseCompleteWord exerciseCompleteWord) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save ExerciseCompleteWord object
			
			session.saveOrUpdate(exerciseCompleteWord);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteExerciseCompleteWordById(long id) {
		
		Transaction transaction = null;
		
		ExerciseCompleteWord exerciseCompleteWord = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ExerciseCompleteWord object
			exerciseCompleteWord = session.get(ExerciseCompleteWord.class, id);
			
			// Delete ExerciseCompleteWord object
			session.delete(exerciseCompleteWord);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
