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

	// private List<User> users = new ArrayList<User>();
	UserDAO userDAO = new UserDAO();

	public UserService() {
		super();

	}

	public List<User> findAll() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDAO userDAOx = (IUserDAO) ac.getBean("userDAO");
		List<User> users = userDAOx.findAll();
		((ClassPathXmlApplicationContext) ac).close();
		return users;
	}

	public User findOne(int id) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDAO userx = (IUserDAO) ac.getBean("userDAO");
		User u = userx.findOne(id);
		((ClassPathXmlApplicationContext) ac).close();
		return u;
	}

	public User createUser(User u) {

		System.out.println("That email is already registered");
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDAO userDAOx = (IUserDAO) ac.getBean("userDAO");
		userDAOx.save(u);
		((ClassPathXmlApplicationContext) ac).close();
		return u;

	}

	public boolean exists(int id) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDAO userDAOx = (IUserDAO) ac.getBean("userDAO");
		List<User> users = userDAOx.findAll();
		((ClassPathXmlApplicationContext) ac).close();
		for (User u : users) {
			if (id == u.getUserid()) {
				return true;
			}
		}

		return false;
	}

	public boolean passwordValid(String email, String password) {
		boolean validpassword = false;
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDAO userDAOx = (IUserDAO) ac.getBean("userDAO");
		List<User> users = userDAOx.findAll();
		for (User user : users) {
			if (user.getUseremail().contentEquals(email)) {
				if (user.getUserpassword().contentEquals(password)) {
					validpassword = true;
				}
			}
		}
		((ClassPathXmlApplicationContext) ac).close();
		return validpassword;
	}

	public User findByEmail(String email) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDAO userx = (IUserDAO) ac.getBean("userDAO");
		User u = userx.findByEmail(email);
		((ClassPathXmlApplicationContext) ac).close();
		return u;
	}

	public boolean emailAlreadyExists(String email) {
		boolean emailisthere = false;
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDAO userDAOx = (IUserDAO) ac.getBean("userDAO");
		List<User> users = userDAOx.findAll();
		for (User user : users) {
			if (user.getUseremail().contentEquals(email)) {
				emailisthere = true;
			}
		}
		return emailisthere;
	}
}