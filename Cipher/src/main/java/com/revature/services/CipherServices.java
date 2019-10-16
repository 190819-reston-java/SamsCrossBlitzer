package com.revature.services;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Forums;
import com.revature.models.User;

@Service
public class CipherServices implements Serializable {

	private static final long serialVersionUID = 4768185896486787814L;

	@Autowired
	private SessionFactory sf;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<User> findAll() {
		Session s = sf.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<User> users = s.createCriteria(User.class).list();	
		return users;
	}

	@Transactional
	public User findOne(int id) {
		Session s = sf.getCurrentSession();
		User u = (User) s.get(User.class, id);		
		return u;		
	}

	@Transactional
	public User update(User u) {
		Session s = sf.getCurrentSession();
		s.update(u);
		return u;
	}

	@Transactional
	public User save(User u) {
		Session s = sf.getCurrentSession();
		s.save(u);
		return u;
	}

	public Forums findPost(int id) {
		Session s = sf.getCurrentSession();
		Forums f = (Forums) s.get(Forums.class, id);		
		return f;		
	}

	public void createNew(Forums forum, Forums f) {
	// please fill me
	}

	

}
