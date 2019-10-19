package com.revature.services;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.revature.models.Forums;
import com.revature.models.Portfolios;
import com.revature.repositories.IForumsDAO;
import com.revature.repositories.IPortfoliosDAO;

@Service
public class PortfoliosService {
	
	public PortfoliosService() {
		super();

	}
	
	public List<Portfolios> findAll() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IPortfoliosDAO portfolioDAO = (IPortfoliosDAO) ac.getBean("PortfoliosDAO"); 
		List<Portfolios> portfolios = portfolioDAO.findAll();
		((ClassPathXmlApplicationContext) ac).close();		
		return portfolios;
	}
	
	

}
