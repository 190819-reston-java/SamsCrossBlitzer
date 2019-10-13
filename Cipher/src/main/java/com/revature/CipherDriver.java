package com.revature;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.IUser;
import com.revature.models.User;
import com.revature.repositories.IUserDAO;

public class CipherDriver {

	private static Configuration configuration;
	private static StandardServiceRegistryBuilder ssrb;
	private static SessionFactory sf;
	private static Session session;
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		IUserDAO userDAO = (IUserDAO) ac.getBean("userDAO");
		
		List<User> users = userDAO.findAll();
		
		for(IUser u : users) {
			System.out.println(u);
		}
		
		
		User newUser = new User();
//		newUser.setUserlastname("Sakurai");
//		newUser.setUserfirstname("Meiru");
//		newUser.setUseremail("MSeiru@rockmanexe.com");
//		newUser.setUserpassword("Heart");
		newUser.setUserlastname("Bear");
		newUser.setUserfirstname("Teddy");
		newUser.setUseremail("Jblack@yahoo.com");
		newUser.setUserpassword("black");
		userDAO.save(newUser);
		((ClassPathXmlApplicationContext) ac).close();
		
	}
/*
	// Adds a record to the database
	private static void addRecord() {
		
		// required session headers
		session = sf.openSession();
		session.beginTransaction();

		// testing adding new record
		IUser newUser = new User();
		newUser.setUserlastname("Sakurai");
		newUser.setUserfirstname("Meiru");
		newUser.setUseremail("MSeiru@rockmanexe.com");
		newUser.setUserpassword("Heart");

		session.save(newUser);
		System.out.println(newUser);

		// required session footer
		session.getTransaction().commit();
		session.close();
		
	}

	// Fetches and Updates a record in the database
	private static void fetchAndUpdate() {
		
		// required session headers
		session = sf.openSession();
		session.beginTransaction();

		// fetching from DB
		System.out.println("getting from DB");
		IUser fetchUser = (IUser) session.get(User.class, 1L); // need to be able to set that "#L" to some variable when called by front-end
		System.out.println(fetchUser);

		// updating the fetch
		fetchUser.setUserfirstname("Lan");
		session.update(fetchUser);

		System.out.println(fetchUser);

		// required session footer
		session.getTransaction().commit();
		session.close();
		
	}
//class closed	
 * 
 */
}
