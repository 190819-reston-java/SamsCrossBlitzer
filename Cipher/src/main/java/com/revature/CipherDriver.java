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
import com.revature.repositories.UserDAO;

public class CipherDriver {

	private static Configuration configuration;
	private static StandardServiceRegistryBuilder ssrb;
	private static SessionFactory sf;
	private static Session session;
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		IUserDAO userDAO = (IUserDAO) ac.getBean("userDAO");
		
		List<User> users = userDAO.findAll();
		
		for(User u : users) {
			System.out.println(u);
		}
		
		
		User newUser = new User();
//		newUser.setUserlastname("Sakurai");
//		newUser.setUserfirstname("Meiru");
//		newUser.setUseremail("MSeiru@rockmanexe.com");
//		newUser.setUserpassword("Heart");
		newUser.setUserlastname("Morgan");
		newUser.setUserfirstname("JP");
		newUser.setUseremail("JPMorgan@yahoo.com");
		newUser.setUserpassword("Chase");
		userDAO.save(newUser);
		((ClassPathXmlApplicationContext) ac).close();
		
	}

}
