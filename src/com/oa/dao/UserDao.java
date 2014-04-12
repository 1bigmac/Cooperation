package com.oa.dao;

import java.io.Serializable;

import com.oa.model.Users;

public interface UserDao {
	public Users login(String hql,Object[] conditions);
	
	public Serializable addUser(Users user);
	
	public void deleteUser(Users user) ;
	
	public void updateUser(Users user);
	
	public Users exits(Serializable account);
}
