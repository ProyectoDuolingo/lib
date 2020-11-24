import lib.duolingoproject.hibernate.dao.IUserDao;
import lib.duolingoproject.hibernate.dao.UserDaoImpl;
import lib.duolingoproject.hibernate.model.User;
import lib.duolingoproject.hibernate.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class Test {

	public static void main(String[] args) {
		
		// User
		
		List<User> userList = new ArrayList<User>();
		
		IUserDao userManager = new UserDaoImpl();
		
		// Saving User
		
		User user = new User();
		
		userManager.saveUser(user);
		
		// Updating User
		
		user.setNickname("Payaso");
		userManager.updateUser(user);
		
		// Get User by Id (Cloning first user)
		
		User user2 = userManager.getUserById(user.getId());
		userManager.saveUser(user2);
		
		// Get All Users
		
		userList = userManager.getAllUsers();
		
		for (int i = 0; i < userList.size(); i++) {
			
			System.out.println("User " + (i+1) + " ID = " + userList.get(i).getId());
			
		}
		
		// Delete User
		
		userManager.deleteUserById(user.getId());
		
		
	}


}
