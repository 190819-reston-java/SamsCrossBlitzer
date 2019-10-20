package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.revature.models.Comment;
import com.revature.models.Forums;
import com.revature.models.User;
import com.revature.repositories.IForumsDAO;
import com.revature.repositories.IUserDAO;

@Service
public class ForumsService {
	
	public ForumsService() {
		super();

	}
	
	public List<Forums> findAll() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IForumsDAO forumDAO = (IForumsDAO) ac.getBean("forumsDAO"); 
		List<Forums> forums = forumDAO.findAll();
		((ClassPathXmlApplicationContext) ac).close();		
		return forums;
	}
	
	public Forums findOne(int id) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IForumsDAO forumDAO = (IForumsDAO) ac.getBean("forumsDAO"); 
		Forums forum = forumDAO.findOne(id);
		((ClassPathXmlApplicationContext) ac).close();		
		return forum;
	}
	
	public Forums createForum(Forums forum) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IForumsDAO forumDAO = (IForumsDAO) ac.getBean("forumsDAO"); 	
		forumDAO.save(forum);
		((ClassPathXmlApplicationContext) ac).close();
		return forum;
	}
	
	public List<Comment> getComments() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IForumsDAO forumDAO = (IForumsDAO) ac.getBean("forumsDAO"); 	
		List<Forums> forumlist = forumDAO.findAll();
		ArrayList<Comment> commentlist = new ArrayList();
		for (Forums f : forumlist) {
			Comment c = new Comment(f.getUser().getUserid(), f.getForumsid(),
			f.getForumstopic(), f.getForumscomment());
			commentlist.add(c);
		}
		((ClassPathXmlApplicationContext) ac).close();
		return commentlist;
	}

}
