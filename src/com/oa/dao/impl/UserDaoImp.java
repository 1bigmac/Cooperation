package com.oa.dao.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oa.dao.SuperDaoInte;
import com.oa.dao.UserDao;
import com.oa.model.User;

@Component("userDao")
public class UserDaoImp implements UserDao {
	private SuperDaoInte superDao;

	public User login(String hql, Object[] conditions) {
		return (User) superDao.check(hql, conditions);
	}

	public SuperDaoInte getSuperDao() {
		return superDao;
	}

	@Resource
	public void setSuperDao(SuperDaoInte superDao) {
		this.superDao = superDao;
	}

	public Serializable addUser(User user) {
		return superDao.add(user);
	}

	public void deleteUser(User user) {
		superDao.delete(user);
	}

	public User exits(Serializable account) {
		return (User) superDao.select(User.class, account);
	}

	public void updateUser(User user) {
		superDao.update(user);
	}

}
