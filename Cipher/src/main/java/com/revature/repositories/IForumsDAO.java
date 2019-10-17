package com.revature.repositories;

import java.util.List;

import com.revature.models.Forums;
import com.revature.models.User;

public interface IForumsDAO {
	public List<Forums> findAll();
	public Forums findOne(int id);
	public Forums update(Forums forum);
	public Forums save(Forums forum);
	public Forums findByUser(User u);
}
