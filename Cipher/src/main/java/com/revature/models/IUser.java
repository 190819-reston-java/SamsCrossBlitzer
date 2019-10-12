package com.revature.models;

import java.util.List;

public interface IUser {

	long getUserid();

	void setUserid(long userid);

	String getUserlastname();

	void setUserlastname(String userlastname);

	String getUserfirstname();

	void setUserfirstname(String userfirstname);

	String getUseremail();

	void setUseremail(String useremail);

	String getUserpassword();

	void setUserpassword(String userpassword);

	String getUserstreetaddress();

	void setUserstreetaddress(String userstreetaddress);

	String getUsercity();

	void setUsercity(String usercity);

	String getUserstate();

	void setUserstate(String userstate);

	List<Forums> getForums();

	void setForums(List<Forums> forums);

	List<Portfolios> getPortfolios();

	void setPortfolios(List<Portfolios> portfolios);

	int hashCode();

	boolean equals(Object obj);

	String toString();

}