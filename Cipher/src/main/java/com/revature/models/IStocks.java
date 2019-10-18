package com.revature.models;

public interface IStocks {

	int getStockid();

	void setStockid(int stockid);

	String getStockshares();

	void setStockshares(String stockshares);

	String getStockcompany();

	void setStockcompany(String stockcompany);

	String getStocksymbol();

	void setStocksymbol(String stocksymbol);

	IPortfolio getPortfolio();

	int hashCode();

	boolean equals(Object obj);

	String toString();

	void setPortfolio(Portfolios portfolio);

}