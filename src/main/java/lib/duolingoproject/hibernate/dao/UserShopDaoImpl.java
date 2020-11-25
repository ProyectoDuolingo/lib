package lib.duolingoproject.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lib.duolingoproject.hibernate.dao.i.IUserShopDao;
import lib.duolingoproject.hibernate.model.association.UserShop;
import lib.duolingoproject.hibernate.util.HibernateUtil;


public class UserShopDaoImpl implements IUserShopDao{
	
	// saveUserShop
	// getAllUserShops
	// getUserShopById
	// updateUserShop
	// deleteUserShopById
	
	public UserShop getUserShopById(long userId, long shopId) {
		
		Transaction transaction = null;
		
		UserShop userShop = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get UserShop object
		
			userShop = session.get(UserShop.class, userShop.new UserShopId(userId, shopId));
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return userShop;
		
	}
	
	public List<UserShop> getAllUserShopsById(long userId) {
		
		Transaction transaction = null;
		
		List<UserShop> userShopsList = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get UserShops list
			userShopsList = session.createQuery("from user_shop where user_id = '" + userId + "'").list();
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return userShopsList;
		
	}
	
	public void saveUserShop(UserShop userShop) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save UserShop object
			
			session.save(userShop);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateUserShop(UserShop userShop) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save UserShop object
			
			session.saveOrUpdate(userShop);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteUserShopById(long userId, long shopId) {
		
		Transaction transaction = null;
		
		UserShop userShop = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get UserShop object
			userShop = session.get(UserShop.class, userShop.new UserShopId(userId, shopId));
			
			// Delete UserShop object
			session.delete(userShop);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
