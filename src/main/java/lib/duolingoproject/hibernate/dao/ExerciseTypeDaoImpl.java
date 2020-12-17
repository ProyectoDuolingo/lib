package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.IExerciseTypeDao;
import lib.duolingoproject.hibernate.model.ExerciseType;
import lib.duolingoproject.hibernate.model.Level;
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
						
			exerciseType = (ExerciseType) session.get(ExerciseType.class, id);
			
			return exerciseType;
			
		} catch (Exception e) {
			
			return null;
			
		}
		
	}
	
	public ExerciseType getExerciseTypeByTypeName(String name) {
		
		Transaction transaction = null;
		
		ExerciseType exerciseType = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
						
			// Get ExerciseType object
			
			exerciseType = (ExerciseType) session.createSQLQuery("select * from exercise_type where exercise_type_name = " + name).addEntity(ExerciseType.class);
			
		} catch (Exception e) {
			
			return null;
			
		}
		
		return exerciseType;
		
	}
	
	public List<ExerciseType> getAllExercisesType() {
				
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
						
			// Get ExerciseType list
			List<ExerciseType> exercisesTypeList = session.createSQLQuery("select * from exercise_type").addEntity(ExerciseType.class).list();
						
			return exercisesTypeList;
			
		} catch (Exception e) {
			
			return null;
			
		}
		
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
