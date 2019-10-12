package com.revature.models;

import java.util.List;

public interface IPortfolio {

	long getPortfolioid();

	void setPortfolioid(long portfolioid);

	double getPortfolioreturn();

	void setPortfolioreturn(double portfolioreturn);

	double getPortfolioamount();

	void setPortfolioamount(double portfolioamount);

	IUser getUser();

	void setUser(IUser user);

	List<Stocks> getStocks();

	void setStocks(List<Stocks> stocks);

	int hashCode();

	boolean equals(Object obj);

	String toString();

}