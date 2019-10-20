package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Forums;
import com.revature.models.User;

@Repository
public class ForumsDAO implements IForumsDAO {

	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Forums> findAll() {
		Session s = sf.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Forums> forums = s.createCriteria(Forums.class).list();	
		return forums;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Forums findOne(int id) {
		Session s = sf.getCurrentSession();
		Forums forums = (Forums) s.get(Forums.class, id);		
		return forums;		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Forums update(Forums forum) {
		Session s = sf.getCurrentSession();
		s.update(forum);
		return forum;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Forums save(Forums forum) {
		Session s = sf.getCurrentSession();
		s.save(forum);
		return forum;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Forums findByUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

}
