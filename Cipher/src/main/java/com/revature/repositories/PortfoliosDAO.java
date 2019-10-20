package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Portfolios;
import com.revature.models.User;

@Repository
public class PortfoliosDAO implements IPortfoliosDAO {

	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Portfolios> findAll() {
		Session s = sf.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Portfolios> portfolios = s.createCriteria(Portfolios.class).list();	
		return portfolios;
	}

	@Override
	@Transactional
	public Portfolios findOne(int id) {
		Session s = sf.getCurrentSession();
		Portfolios portfolios = (Portfolios) s.get(Portfolios.class, id);		
		return portfolios;		
	}

	@Override
	@Transactional
	public Portfolios update(Portfolios portfolios) {
		Session s = sf.getCurrentSession();
		s.update(portfolios);
		return portfolios;
	}

	@Override
	@Transactional
	public Portfolios save(Portfolios portfolios) {
		Session s = sf.getCurrentSession();
		s.save(portfolios);
		return portfolios;
	}

	@Override
	@Transactional
	public Portfolios findByUser(User u) {
		return null;
	}

}
