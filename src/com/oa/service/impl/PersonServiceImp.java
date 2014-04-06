package com.oa.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oa.dao.PersonDao;
import com.oa.model.Person;
import com.oa.service.PersonService;
@Component("personService")
public class PersonServiceImp implements PersonService {
	private PersonDao personDao;
	/* (non-Javadoc)
	 * @see com.oa.service.impl.PersonService#addPerson(com.oa.model.Person)
	 */
	public Serializable addPerson(Person person){
		return personDao.addPerson(person);
	}
	
	/* (non-Javadoc)
	 * @see com.oa.service.impl.PersonService#updatePerson(com.oa.model.Person)
	 */
	public void updatePerson(Person person){
		personDao.update(person);
	}
	
	/* (non-Javadoc)
	 * @see com.oa.service.impl.PersonService#deletePerson(com.oa.model.Person)
	 */
	public void deletePerson(Person person){
		personDao.delete(person);
	}
	
	/* (non-Javadoc)
	 * @see com.oa.service.impl.PersonService#getPerson(java.io.Serializable)
	 */
	public Person getPerson(Serializable id){
		return personDao.getPerson(Person.class,id);
	}
	
	/* (non-Javadoc)
	 * @see com.oa.service.impl.PersonService#getAllPersons(java.lang.Class, java.lang.String)
	 */
	public List<Person> getAllPersons(Class clazz,String hql){
		return personDao.getAllPersons(Person.class, hql);
	}
	/* (non-Javadoc)
	 * @see com.oa.service.impl.PersonService#getPagePersons(int, java.lang.Class, java.lang.String)
	 */
	public List<Person> getPagePersons(int index,Class clazz,String hql){
		return personDao.getPagePerson(index, clazz, hql);
	}
	

	/* (non-Javadoc)
	 * @see com.oa.service.impl.PersonService#getPersonDao()
	 */
	public PersonDao getPersonDao() {
		return personDao;
	}

	/* (non-Javadoc)
	 * @see com.oa.service.impl.PersonService#setPersonDao(com.oa.dao.PersonDao)
	 */
	@Resource
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	public void deletePersons(String ids[]){
		String hql="delete from Person p where p.id ";
		personDao.deletePersons(Person.class, ids,hql);
	}
}
