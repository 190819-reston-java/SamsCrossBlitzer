package com.revature.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Forums;
import com.revature.models.User;
import com.revature.services.CipherServices;

@Controller
public class CipherController implements Serializable {

	@Autowired
	private SessionFactory sf;
	

	private static final long serialVersionUID = 1797755545473900760L;


	@Autowired
	public CipherServices cipherServices;
	
	@RequestMapping(method = RequestMethod.GET, value = "/home")
	public String home() {
		return "home";
	}
	
	@GetMapping(value ="/user")
	@ResponseBody
	public List<User> findAll() {
		return cipherServices.findAll();
	}

	@GetMapping(value ="/user/{id}")
	@ResponseBody
	public ResponseEntity<User> findOne(@PathVariable("id") int id) {
		User u = cipherServices.findOne(id);
		
		  if(u != null) { return ResponseEntity.status(HttpStatus.OK).body(u); }
		  
		  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public ResponseEntity<String> sayHello(){
		return new ResponseEntity<String>("Hello!", HttpStatus.OK);
	}
	
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
}
