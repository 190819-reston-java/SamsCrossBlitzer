package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Comment;
import com.revature.models.Forums;
import com.revature.models.User;
import com.revature.services.ForumsService;
import com.revature.services.UserService;

@Controller
@CrossOrigin("http://localhost:4200")
public class CipherController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ForumsService forumservice;
	
	@RequestMapping(method = RequestMethod.GET, value = "/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/test")
	@ResponseBody
	public User getRobot() {
		User navi = new User();
		navi.setUserfirstname("Rock");
		navi.setUserlastname("Man");
		System.out.println(navi);
				
		return navi;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/test2")
	@ResponseBody
	public User getBot() {
		User roll = userService.findOne(3);
		System.out.println(roll);
		return roll;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/currentuser")
	@ResponseBody 
	ResponseEntity<User> currentUser(HttpServletRequest req, 
				HttpServletResponse resp) throws ServletException, IOException{
		User usercurrentuser = (User) req.getSession().getAttribute("loggedinuser");
		System.out.println(usercurrentuser);
		
		return ResponseEntity.status(HttpStatus.OK).body(usercurrentuser);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/userlogin")
	@ResponseBody
	public ResponseEntity<User> login(@RequestBody String json, HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException{

		String[] s = json.split(",");
		String useremail = s[0].substring(10, s[0].length()-1);

		String userpassword = s[1].substring(12, s[1].length()-2);

		User u = userService.findByEmail(useremail);
		if (u == null) {
			System.out.println("That email does not exist");
//			resp.sendRedirect("http://localhost:4200/login/");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(u);
		}
		else {
			if (userService.passwordValid(useremail, userpassword)) {
				HttpSession t = req.getSession();
				t.setAttribute("loggedinuser", u);
				req.getSession().setAttribute("loggedinuser", u);
//				resp.encodeRedirectURL("http://localhost:4200");
//				resp.sendRedirect("http://localhost:4200");
				System.out.println(u);
				return ResponseEntity.status(HttpStatus.OK).body(u);
				
				
			}
			
			else {
				System.out.println("Password is Invalid");
				resp.sendRedirect("http://localhost:4200/login");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(u);
			}
		
		}
		
	}
	
    @GetMapping(value="/logout")
    @ResponseBody
    public void logoutuser(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("User logged out");
        req.getSession().setAttribute("loggedinuser", null);
    }
    
    @GetMapping(value="/comments")
    @ResponseBody
    public List<Comment> getComments() {
        return forumservice.getComments();
    }
	
	@GetMapping(value="/forums")
	@ResponseBody
	public List<Forums> findAllForums() {
		return forumservice.findAll();
		
	}
	
	@GetMapping(value = "/forums/{id}")
	@ResponseBody
	public Forums findForum(@PathVariable("id") int id) {
		Forums forum = forumservice.findOne(id);
	    return forum;	

	}
	
	
	@GetMapping(value="/users")
	@ResponseBody
	public List<User> findAll() {
		return userService.findAll();
		
	}
	
	@GetMapping(value = "/users/{id}")
	@ResponseBody
	public User findOne(@PathVariable("id") int id) {
//	public ResponseEntity<User> findOne(@PathVariable("id") int id) {
		User u = userService.findOne(id);
	    return u;	
//		  if(u != null) { return ResponseEntity.status(HttpStatus.OK).body(u); }
		  
//		  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/registration")
	@ResponseBody
	public ResponseEntity<String> register(@RequestBody String json) {
		User u = new User();
		System.out.println(json);
		String[] s = json.split(",");
		System.out.println(s[2] + " " + s[3]);
		String firstname = s[0].substring(14, s[0].length()-1);
		u.setUserfirstname(firstname);
		String lastname = s[1].substring(12, s[1].length()-1);
		u.setUserlastname(lastname);
		String useremail = s[2].substring(9, s[2].length()-1);
		u.setUseremail(useremail);
		String userpassword = s[3].substring(12, s[3].length()-2);
		u.setUserpassword(userpassword);
		userService.createUser(u);
		System.out.println(userpassword);
		System.out.println(json);
		return null;
	}
	
	@PostMapping(value = "*/createforum")
	@ResponseBody
	public List<Comment> createForumComment(@RequestBody String json, HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException{
			
			//User commentor = (User) req.getSession().getAttribute("loggedinuser");
			System.out.println("In Create forum");
		    System.out.println(json);
		    return forumservice.getComments();
			//Forums newforum = new Forums();
			//newforum.setForumscomment(forumscomment);
			//newforum.setForumstopic(forumstopic);
			//newforum.setUser(commentor);
			//System.out.println(commentor);
			//System.out.println(forumscomment);
			//System.out.println(forumstopic);
			//forumservice.createForum(newforum);
	}
	
	@PostMapping(value = "/comments")
	@ResponseBody
	public String addForumComment(@RequestBody String json, HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException{
			
			//User commentor = (User) req.getSession().getAttribute("loggedinuser");
			System.out.println("In Create forum");
		    System.out.println(json);
		    String[] s = json.split(",");
		    String forumstopic =  s[0].substring(9, s[0].length()-1);
		    String forumscomment = s[1].substring(7, s[1].length()-2);
		    return json;
			//Forums newforum = new Forums();
			//newforum.setForumscomment(forumscomment);
			//newforum.setForumstopic(forumstopic);
			//newforum.setUser(commentor);
			//System.out.println(commentor);
			//System.out.println(forumscomment);
			//System.out.println(forumstopic);
			//forumservice.createForum(newforum);
	}

/*
	@PutMapping(value = "/forums")
	@ResponseBody
	public ResponseEntity<Forums> createNew(HttpServletRequest request, HttpServletResponse response, Forums forum) {

		Forums f = (Forums) request.getSession().getAttribute("currentUser");
		
		if(f == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		cipherServices.createNew(forum, f);
		return ResponseEntity.status(HttpStatus.OK).body(forum);
	}
*/

}