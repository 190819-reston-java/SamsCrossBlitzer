package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Forums;
import com.revature.models.User;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;
import com.revature.services.ForumsService;
import com.revature.services.UserService;

@Controller
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
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/currentuser")
    @ResponseBody
    public ResponseEntity<User> currentUser(HttpServletRequest req,
                HttpServletResponse resp) throws ServletException, IOException{
        User currentuser = (User) req.getSession().getAttribute("loggedinuser");
        System.out.println(currentuser);
        
        return ResponseEntity.status(HttpStatus.OK).body(currentuser);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "*/userlogin")
	@ResponseBody
	public ResponseEntity<User> login(@RequestParam String useremail, @RequestParam String userpassword, HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException{

//		String[] s = json.split(",");
//		String useremail = s[0].substring(10, s[0].length()-1);

//		String userpassword = s[1].substring(12, s[1].length()-2);

		User u = userService.findByEmail(useremail);
		if (u == null) {
			System.out.println("That email does not exist");
//			resp.sendRedirect("http://localhost:4200/login/");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(u);
		}
		else {
			if (userService.passwordValid(useremail, userpassword)) {
				req.getSession().setAttribute("loggedinuser", u);
//				resp.sendRedirect("http://localhost:4200/home");
				return ResponseEntity.status(HttpStatus.OK).body(u);
				
			}
			
			else {
				System.out.println("Password is Invalid");
				resp.sendRedirect("http://localhost:4200/login");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(u);
			}
		
		}
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/test2")
	@ResponseBody
	public User getBot() {
		User roll = userService.findOne(3);
		System.out.println(roll);
		return roll;
	}
	
//	@GetMapping(value ="*/userlogin")
//	@ResponseBody
//	public User login(@RequestParam String useremail, @RequestParam String userpassword){
//		
//		User u = userService.findByEmail(useremail);
//		if (u == null) {
//			System.out.println("That email does not exist");
//			return u;
//		}
//		else {
//			if (userService.passwordValid(useremail, userpassword)) {
//				return u;
//			}
//			
//			else {
//				System.out.println("Password is Invalid");
//				return u;
//			}
//		
//		}
//		
//	}
	
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
	
	@PostMapping(value = "*/registration")
	@ResponseBody
	public void register(@RequestParam String useremail, @RequestParam String userpassword,
			@RequestParam String userfirstname, @RequestParam String userlastname){
			User u = new User();
			u.setUserfirstname(userfirstname);
			u.setUserlastname(userlastname);
			u.setUseremail(useremail);
			u.setUserpassword(userpassword);
			userService.createUser(u);
		
	}
	
	@PostMapping(value = "*/createforum")
	@ResponseBody
	public void createForumComment(@RequestParam String forumstopic, @RequestParam String forumscomment, HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException{
			
			User commentor = (User) req.getSession().getAttribute("loggedinuser");
			Forums newforum = new Forums();
			newforum.setForumscomment(forumscomment);
			newforum.setForumstopic(forumstopic);
			newforum.setUser(commentor);
			System.out.println(commentor);
			System.out.println(forumscomment);
			System.out.println(forumstopic);
			forumservice.createForum(newforum);
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
