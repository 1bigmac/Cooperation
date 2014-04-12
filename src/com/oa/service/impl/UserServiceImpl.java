package com.oa.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oa.dao.UserDao;
import com.oa.model.Users;
import com.oa.service.UserService;
@Component("userService")
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public Users login(String hql, Object[] condition) {
		return userDao.login(hql, condition);
	}

	public UserDao getUserDao() {
		return userDao;
	}
  
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void delete(Users user) {
		userDao.deleteUser(user);
	}

	public void update(Users user) {
		userDao.updateUser(user);
	}

	public Serializable addUser(Users user) {
		return userDao.addUser(user);
	}

	public Users exits(Serializable account) {
		return userDao.exits(account);
	}

}
