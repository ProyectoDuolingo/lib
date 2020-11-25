package lib.duolingoproject.hibernate.dao;

import lib.duolingoproject.hibernate.dao.i.IShopItemDao;
import lib.duolingoproject.hibernate.model.ShopItem;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class ShopItemDaoImpl implements IShopItemDao{
	
	// saveShopItem
	// getAllShopItems
	// getShopItemById
	// updateShopItem
	// deleteShopItemById
	
	public ShopItem getShopItemById(long id) {
		
		Transaction transaction = null;
		
		ShopItem shopItem = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ShopItem object
			
			shopItem = session.get(ShopItem.class, id);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return shopItem;
		
	}
	
	public List<ShopItem> getAllShopItems() {
		
		Transaction transaction = null;
		
		List<ShopItem> shopItemsList = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ShopItems list
			shopItemsList = session.createQuery("from shop_item").list();
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
		return shopItemsList;
		
	}
	
	public void saveShopItem(ShopItem shopItem) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save ShopItem object
			
			session.save(shopItem);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void updateShopItem(ShopItem shopItem) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Save ShopItem object
			
			session.saveOrUpdate(shopItem);
			
			// Commit the transaction
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}
	
	public void deleteShopItemById(long id) {
		
		Transaction transaction = null;
		
		ShopItem shopItem = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start the transaction
			
			transaction = session.beginTransaction();
			
			// Get ShopItem object
			shopItem = session.get(ShopItem.class, id);
			
			// Delete ShopItem object
			session.delete(shopItem);
			
			// Commit the transaction
			transaction.commit();
			
		} catch (Exception e) {
			
			if (transaction != null) {
				
				transaction.rollback();
				
			}
			
		}
		
	}

}
