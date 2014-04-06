package com.oa.service;

import java.io.Serializable;
import java.util.List;

import com.oa.model.Organization;

public interface OrganizationService {

	public Serializable add(Object model);
	public void update(Object model);
	public void delete(Object model);
	public List<Organization> find();

}