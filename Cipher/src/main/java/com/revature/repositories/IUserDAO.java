package com.revature.repositories;

import java.util.List;

import com.revature.models.IUser;
import com.revature.models.User;

public interface IUserDAO {
	public List<User> findAll();
	public User findOne(int id);
	public User update(User u);
	public User save(User u);

}
