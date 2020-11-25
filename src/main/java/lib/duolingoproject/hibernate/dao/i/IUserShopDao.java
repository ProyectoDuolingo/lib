package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.association.UserShop;

public interface IUserShopDao {
	
	public UserShop getUserShopById(long userId, long ShopId);
	public List<UserShop> getAllUserShopsById(long userId);
	public void saveUserShop(UserShop userShop);
	public void updateUserShop(UserShop userShop);
	public void deleteUserShopById(long userId, long ShopId);

}
