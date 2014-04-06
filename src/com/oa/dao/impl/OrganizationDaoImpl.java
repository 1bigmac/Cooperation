package com.oa.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import com.oa.dao.OrganizationDao;
import com.oa.dao.SuperDaoInte;
import com.oa.model.Organization;

@Component("organizationDao")
public class OrganizationDaoImpl implements OrganizationDao {

	private SuperDaoInte superDao;

	public Serializable add(Object model) {
		return superDao.add(model);
	}

	public void update(Object model) {
		superDao.update(model);
	}
	
	public void delete(Object model) {
		superDao.delete(model);
	}

	public List<Organization> find() {
		return ConvertObject(superDao.find("from Organization"));
	}
	
	public List<Organization> ConvertObject(List<Object> list) {
		List<Organization> listOrg = null;
		for(int i=0; i<list.size(); i++) {
			listOrg = new ArrayList<Organization>();
			listOrg.add((Organization)list.get(i));
		}
		return listOrg;
	}
	
	public SuperDaoInte getSuperDao() {
		return superDao;
	}
	@Resource
	public void setSuperDao(SuperDaoInte superDao) {
		this.superDao = superDao;
	}
	
	
}
