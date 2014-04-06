package com.oa.dao;

import java.io.Serializable;

import com.oa.model.User;

public interface UserDao {
	public User login(String hql,Object[] conditions);
	
	public Serializable addUser(User user);
	
	public void deleteUser(User user) ;
	
	public void updateUser(User user);
	
	public User exits(Serializable account);
}
