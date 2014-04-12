package com.oa.dao.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oa.dao.SuperDaoInte;
import com.oa.dao.UserDao;
import com.oa.model.Users;

@Component("userDao")
public class UserDaoImp implements UserDao {
	private SuperDaoInte superDao;

	public Users login(String hql, Object[] conditions) {
		return (Users) superDao.check(hql, conditions);
	}

	public SuperDaoInte getSuperDao() {
		return superDao;
	}

	@Resource
	public void setSuperDao(SuperDaoInte superDao) {
		this.superDao = superDao;
	}

	public Serializable addUser(Users user) {
		return superDao.add(user);
	}

	public void deleteUser(Users user) {
		superDao.delete(user);
	}

	public Users exits(Serializable account) {
		return (Users) superDao.select(Users.class, account);
	}

	public void updateUser(Users user) {
		superDao.update(user);
	}

}
