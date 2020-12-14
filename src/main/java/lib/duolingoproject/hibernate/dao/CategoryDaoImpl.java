package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.ICategoryDao;
import lib.duolingoproject.hibernate.model.Category;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class CategoryDaoImpl implements ICategoryDao{
	
	// saveCategory
	// getAllCategorys
	// getCategoryById
	// updateCategory
	// deleteCategoryById
	
	public Category getCategoryById(long id) {
		
		Transaction transaction = null;
		
		Category category = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get Category object
			
			category = session.get(Category.class, id);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return category;
		
	}
	
	public List<Category> getAllCategoriesByCourseId(long id) {
			
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Get Categories list
			List<Category> categoriesList = session.createSQLQuery("select * from category where course_id = " + id).addEntity(Category.class).list();
						
			return categoriesList;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return null;
			
		}
		
	}
	
	public void saveCategory(Category category) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save Category object
			
			session.save(category);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateCategory(Category category) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save Category object
			
			session.saveOrUpdate(category);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteCategoryById(long id) {
		
		Transaction transaction = null;
		
		Category category = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get Category object
			category = session.get(Category.class, id);
			
			// Delete Category object
			session.delete(category);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
