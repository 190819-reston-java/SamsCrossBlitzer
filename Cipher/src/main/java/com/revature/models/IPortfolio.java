package com.revature.models;

import java.util.List;

public interface IPortfolio {

	int getPortfolioid();

	void setPortfolioid(int portfolioid);

	double getPortfolioreturn();

	void setPortfolioreturn(double portfolioreturn);

	double getPortfolioamount();

	void setPortfolioamount(double portfolioamount);

	User getUser();

	void setUser(User user);

	List<Stocks> getStocks();

	void setStocks(List<Stocks> stocks);

	int hashCode();

	boolean equals(Object obj);

	String toString();

}
