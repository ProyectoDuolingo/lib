package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.IDivisionDao;
import lib.duolingoproject.hibernate.model.Division;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class DivisionDaoImpl implements IDivisionDao{
	
	// saveDivision
	// getAllDivisions
	// getDivisionById
	// updateDivision
	// deleteDivisionById
	
	public Division getDivisionById(long id) {
		
		Transaction transaction = null;
		
		Division division = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get Division object
			
			division = session.get(Division.class, id);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return division;
		
	}
	
	public List<Division> getAllDivisions() {
		
		Transaction transaction = null;
		
		List<Division> divisionsList = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get Divisions list
			divisionsList = session.createQuery("from division").list();
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return divisionsList;
		
	}
	
	public void saveDivision(Division division) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save Division object
			
			session.save(division);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateDivision(Division division) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save Division object
			
			session.saveOrUpdate(division);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteDivisionById(long id) {
		
		Transaction transaction = null;
		
		Division division = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get Division object
			division = session.get(Division.class, id);
			
			// Delete Division object
			session.delete(division);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
