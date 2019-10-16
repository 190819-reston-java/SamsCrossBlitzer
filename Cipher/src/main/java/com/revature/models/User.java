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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="users")
public class User implements Serializable, IUser {


	private static final long serialVersionUID = -4553508689874995351L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userid;
	
	@Column(name="user_lastname")
	private String userlastname;
	
	
	@Column(name="user_firstname")
	private String userfirstname;
	
	@Column(name="user_email")
	private String useremail;
	
	@Column(name="user_password")
	private String userpassword;
	
	@Column(name="streetaddress")
	private String userstreetaddress;
	
	@Column(name="user_city")
	private String usercity;
	
	@Column(name="user_state")
	private String userstate;
	
	
	// Generated by Source menu - empty constructor for jackson
	public User() {
		super();
	}

	public User(int userid, String userlastname, String userfirstname, String useremail, String userpassword,
			String userstreetaddress, String usercity, String userstate) {
		super();
		this.userid = userid;
		this.userlastname = userlastname;
		this.userfirstname = userfirstname;
		this.useremail = useremail;
		this.userpassword = userpassword;
		this.userstreetaddress = userstreetaddress;
		this.usercity = usercity;
		this.userstate = userstate;
	}


	public int getUserid() {
		return userid;
	}


	@Override
	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getUserlastname() {
		return userlastname;
	}


	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}


	public String getUserfirstname() {
		return userfirstname;
	}


	public void setUserfirstname(String userfirstname) {
		this.userfirstname = userfirstname;
	}


	public String getUseremail() {
		return useremail;
	}


	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}


	public String getUserpassword() {
		return userpassword;
	}


	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}


	public String getUserstreetaddress() {
		return userstreetaddress;
	}


	public void setUserstreetaddress(String userstreetaddress) {
		this.userstreetaddress = userstreetaddress;
	}


	public String getUsercity() {
		return usercity;
	}


	public void setUsercity(String usercity) {
		this.usercity = usercity;
	}


	public String getUserstate() {
		return userstate;
	}


	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}


	@Override
	public int hashCode() {
		return Objects.hash(usercity, useremail, userfirstname, userid, userlastname, userpassword, userstate,
				userstreetaddress);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(usercity, other.usercity) && Objects.equals(useremail, other.useremail)
				&& Objects.equals(userfirstname, other.userfirstname) && userid == other.userid
				&& Objects.equals(userlastname, other.userlastname) && Objects.equals(userpassword, other.userpassword)
				&& Objects.equals(userstate, other.userstate)
				&& Objects.equals(userstreetaddress, other.userstreetaddress);
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", userlastname=" + userlastname + ", userfirstname=" + userfirstname
				+ ", useremail=" + useremail + ", userpassword=" + userpassword + ", userstreetaddress="
				+ userstreetaddress + ", usercity=" + usercity + ", userstate=" + userstate + "]";
	}
	

//class closed
}