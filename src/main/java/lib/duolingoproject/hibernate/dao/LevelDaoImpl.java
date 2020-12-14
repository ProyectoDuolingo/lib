package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.ILevelDao;
import lib.duolingoproject.hibernate.model.Level;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class LevelDaoImpl implements ILevelDao{
	
	// saveLevel
	// getAllLevels
	// getLevelById
	// updateLevel
	// deleteLevelById
	
	public Level getLevelById(long id) {
		
		Transaction transaction = null;
		
		Level level = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get Level object
			
			level = session.get(Level.class, id);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return level;
		
	}
	
	public List<Level> getAllLevelsByCategoryId(long id) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
						
			// Get Levels list
			List<Level> levelsList = session.createSQLQuery("select * from level where category_id = " + id).addEntity(Level.class).list();
			
			return levelsList;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return null;
			
		}
		
	}
	
	public void saveLevel(Level level) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save Level object
			
			session.save(level);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateLevel(Level level) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save Level object
			
			session.saveOrUpdate(level);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteLevelById(long id) {
		
		Transaction transaction = null;
		
		Level level = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get Level object
			level = session.get(Level.class, id);
			
			// Delete Level object
			session.delete(level);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
