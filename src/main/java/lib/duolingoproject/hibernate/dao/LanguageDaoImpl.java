package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.ILanguageDao;
import lib.duolingoproject.hibernate.model.Language;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class LanguageDaoImpl implements ILanguageDao{
	
	// saveLanguage
	// getAllLanguages
	// getLanguageById
	// updateLanguage
	// deleteLanguageById
	
	public Language getLanguageById(long id) {
		
		Transaction transaction = null;
		
		Language language = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get Language object
			
			language = session.get(Language.class, id);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return language;
		
	}
	
	public List<Language> getAllLanguages() {
		
		Transaction transaction = null;
		
		List<Language> languagesList = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get Languages list
			languagesList = session.createQuery("from language").list();
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return languagesList;
		
	}
	
	public void saveLanguage(Language language) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save Language object
			
			session.save(language);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateLanguage(Language language) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save Language object
			
			session.saveOrUpdate(language);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteLanguageById(long id) {
		
		Transaction transaction = null;
		
		Language language = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get Language object
			language = session.get(Language.class, id);
			
			// Delete Language object
			session.delete(language);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
