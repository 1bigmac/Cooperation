package com.oa.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.oa.dao.PersonDao;
import com.oa.model.Person;

public interface PersonService {

	public abstract Serializable addPerson(Person person);

	public abstract void updatePerson(Person person);

	public abstract void deletePerson(Person person);

	public abstract Person getPerson(Serializable id);

	public abstract List<Person> getAllPersons(Class clazz, String hql);

	public abstract List<Person> getPagePersons(int index, Class clazz,
			String hql);

	public abstract PersonDao getPersonDao();

	@Resource
	public abstract void setPersonDao(PersonDao personDao);
	
	public void deletePersons(String ids[]);

}