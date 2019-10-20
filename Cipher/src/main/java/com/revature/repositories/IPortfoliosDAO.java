package com.revature.repositories;

import java.util.List;

import com.revature.models.Portfolios;
import com.revature.models.User;

public interface IPortfoliosDAO {
	public List<Portfolios> findAll();
	public Portfolios findOne(int id);
	public Portfolios update(Portfolios portfolios);
	public Portfolios save(Portfolios portfolios);
	public Portfolios findByUser(User u);

}
