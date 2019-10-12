package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="stocks")
public class Stocks implements Serializable, IStocks {

	
	private static final long serialVersionUID = 4702830964184648935L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stocks_id")	
	private int stockid;
	
	@Column(name="stock_shares")
	private String stockshares;
	
	@Column(name="stock_company")
	private String stockcompany;
	
	@Column(name="stock_symbol")
	private String stocksymbol;
	
	@ManyToOne
	@JoinColumn(name ="stock_portfolio")
	private IPortfolio portfolio;

	public Stocks() {
		super();
	}

	public Stocks(int stockid, String stockshares, String stockcompany, String stocksymbol, IPortfolio portfolio) {
		super();
		this.stockid = stockid;
		this.stockshares = stockshares;
		this.stockcompany = stockcompany;
		this.stocksymbol = stocksymbol;
		this.portfolio = portfolio;
	}

	@Override
	public int getStockid() {
		return stockid;
	}

	@Override
	public void setStockid(int stockid) {
		this.stockid = stockid;
	}

	@Override
	public String getStockshares() {
		return stockshares;
	}

	@Override
	public void setStockshares(String stockshares) {
		this.stockshares = stockshares;
	}

	@Override
	public String getStockcompany() {
		return stockcompany;
	}

	@Override
	public void setStockcompany(String stockcompany) {
		this.stockcompany = stockcompany;
	}

	@Override
	public String getStocksymbol() {
		return stocksymbol;
	}

	@Override
	public void setStocksymbol(String stocksymbol) {
		this.stocksymbol = stocksymbol;
	}

	@Override
	public IPortfolio getPortfolio() {
		return portfolio;
	}

	@Override
	public void setPortfolio(IPortfolio portfolio) {
		this.portfolio = portfolio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(portfolio, stockcompany, stockid, stockshares, stocksymbol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stocks other = (Stocks) obj;
		return Objects.equals(portfolio, other.portfolio) && Objects.equals(stockcompany, other.stockcompany)
				&& stockid == other.stockid && Objects.equals(stockshares, other.stockshares)
				&& Objects.equals(stocksymbol, other.stocksymbol);
	}

	@Override
	public String toString() {
		return "Stocks [stockid=" + stockid + ", stockshares=" + stockshares + ", stockcompany=" + stockcompany
				+ ", stocksymbol=" + stocksymbol + ", portfolio=" + portfolio + "]";
	}

	
}	