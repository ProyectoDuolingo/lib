package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.ShopItem;

public interface IShopItemDao {

	public ShopItem getShopItemById(long id);
	public List<ShopItem> getAllShopItems();
	public void saveShopItem(ShopItem shopItem);
	public void updateShopItem(ShopItem shopItem);
	public void deleteShopItemById(long id);
}
