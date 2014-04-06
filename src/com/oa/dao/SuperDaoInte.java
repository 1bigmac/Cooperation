package com.oa.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

public interface SuperDaoInte {

	public abstract Serializable add(Object model);

	public abstract void delete(Object model);

	public abstract void update(Object model);

	public abstract Object select(Class clazz, Serializable id);



	public abstract List<Object> find(String hql);

	// login- user
	public abstract Object check(String hql, Object[] condition);

	public abstract List<Object> getAllObjects(Class clazz, String hql);

	public abstract List<Object> getPage(int index, Class clazz, String hql);

	public abstract HibernateTemplate getHibernateTemplate();

	@Resource
	public abstract void setHibernateTemplate(
			HibernateTemplate hibernateTemplate);
	

	public void deleteList(Class clazz,Object []ids,String hql);
	

}