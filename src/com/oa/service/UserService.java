package com.oa.service;


import java.io.Serializable;

import com.oa.model.Users;

public interface UserService {
	public Users login(String hql,Object[] condition);
	public void delete(Users user);
	public void update(Users user);
	public Serializable addUser(Users user);
	
	public Users exits(Serializable account);
}
