package com.oa.service;


import java.io.Serializable;

import com.oa.model.User;

public interface UserService {
	public User login(String hql,Object[] condition);
	public void delete(User user);
	public void update(User user);
	public Serializable addUser(User user);
	
	public User exits(Serializable account);
}
