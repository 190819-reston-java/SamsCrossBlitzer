package com.revature.models;
import java.io.Serializable;

public class Comment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5258943309180960198L;
	
	public int userId;
	public int id;
	public String title;
	public String body;
	
	public Comment(int userId, int id, String title, String body) {
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}

	@Override
	public String toString() {
		return "Comment [userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body + "]";
	}
	
	


}