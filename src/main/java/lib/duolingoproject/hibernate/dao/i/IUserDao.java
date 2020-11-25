package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.User;

public interface IUserDao {
	
	public User getUserById(long id);
	public List<User> getAllUsers();
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUserById(long id);

}
