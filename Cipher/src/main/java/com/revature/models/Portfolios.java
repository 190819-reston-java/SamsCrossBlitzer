package com.revature.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="portfolios")
public class Portfolios implements Serializable, IPortfolio {


	private static final long serialVersionUID = -195234255365846115L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="portfolio_id")
	private int portfolioid;
	
	@Column(name="portfolio_return")
	private double portfolioreturn;
	
	@Column(name="portfolio_amount")
	private double portfolioamount;
	
	
	@ManyToOne
	@JoinColumn(name ="portfolio_user")
	private User user;

	@Autowired
	@OneToMany( mappedBy="portfolio")
	private List<Stocks> stocks;
	
	public Portfolios() {
		super();
	}

	public Portfolios(int portfolioid, double portfolioreturn, double portfolioamount, User user, List<Stocks> stocks) {
		super();
		this.portfolioid = portfolioid;
		this.portfolioreturn = portfolioreturn;
		this.portfolioamount = portfolioamount;
		this.user = user;
		this.stocks = stocks;
	}

	public int getPortfolioid() {
		return portfolioid;
	}

	public void setPortfolioid(int portfolioid) {
		this.portfolioid = portfolioid;
	}

	public double getPortfolioreturn() {
		return portfolioreturn;
	}

	public void setPortfolioreturn(double portfolioreturn) {
		this.portfolioreturn = portfolioreturn;
	}

	public double getPortfolioamount() {
		return portfolioamount;
	}

	public void setPortfolioamount(double portfolioamount) {
		this.portfolioamount = portfolioamount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Stocks> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stocks> stocks) {
		this.stocks = stocks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(portfolioamount, portfolioid, portfolioreturn, stocks, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Portfolios other = (Portfolios) obj;
		return Double.doubleToLongBits(portfolioamount) == Double.doubleToLongBits(other.portfolioamount)
				&& portfolioid == other.portfolioid
				&& Double.doubleToLongBits(portfolioreturn) == Double.doubleToLongBits(other.portfolioreturn)
				&& Objects.equals(stocks, other.stocks) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Portfolios [portfolioid=" + portfolioid + ", portfolioreturn=" + portfolioreturn + ", portfolioamount="
				+ portfolioamount + ", user=" + user + ", stocks=" + stocks + "]";
	}

	
//class closed	
}