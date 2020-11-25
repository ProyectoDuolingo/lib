package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.ILeagueDao;
import lib.duolingoproject.hibernate.model.League;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class LeagueDaoImpl implements ILeagueDao{
	
	// saveLeague
	// getAllLeagues
	// getLeagueById
	// updateLeague
	// deleteLeagueById
	
	public League getLeagueById(long id) {
		
		Transaction transaction = null;
		
		League league = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get League object
			
			league = session.get(League.class, id);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return league;
		
	}
	
	public List<League> getAllLeagues() {
		
		Transaction transaction = null;
		
		List<League> leaguesList = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get Leagues list
			leaguesList = session.createQuery("from league").list();
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return leaguesList;
		
	}
	
	public void saveLeague(League league) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save League object
			
			session.save(league);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateLeague(League league) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save League object
			
			session.saveOrUpdate(league);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteLeagueById(long id) {
		
		Transaction transaction = null;
		
		League league = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get League object
			league = session.get(League.class, id);
			
			// Delete League object
			session.delete(league);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
