package com.oa.dao;

import java.io.Serializable;
import java.util.List;

import com.oa.model.Organization;

public interface OrganizationDao {
	public Serializable add(Object model);
	public void update(Object model);
	public void delete(Object model);
	public List<Organization> find();
}
