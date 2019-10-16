package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.repositories.IUserDAO;

@Service
public class UserService {
	
	//private List<User> users = new ArrayList<User>();
	UserDAO userDAO = new UserDAO();
	
//	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//	private IUserDAO userDAO = (IUserDAO) ac.getBean("userDAO");
//	((ClassPathXmlApplicationContext) ac).close();

	public UserService() {
		super();
//		users.add(new User(1, "Steve", "Jobs", new Account(2000000)));
//		users.add(new User(2, "John", "Smith", new Account(20)));
	}
	
	public List<User> findAll() {
		List<User> users = userDAO.findAll();
		return users;
	}

	public User findOne(int id) {
		
		User u = userDAO.findOne(id);
		return u;
	}
	
	public User save(User u) {
		userDAO.save(u);
		return u;
	}
	
	public boolean exists(int id) {
		List<User> users = userDAO.findAll();
		for(User u : users) {
			if(id == u.getUserid()) {
				return true;
			}
		}
		
		return false;
	}
	

}