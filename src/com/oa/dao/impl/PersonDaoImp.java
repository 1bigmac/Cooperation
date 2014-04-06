package com.oa.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oa.dao.PersonDao;
import com.oa.dao.SuperDaoInte;
import com.oa.model.Person;
@Component("personDao")
public class PersonDaoImp implements  PersonDao {
	
	private SuperDaoInte superDao;
	/* (non-Javadoc)
	 * @see com.oa.dao.impl.PersonDao#addPerson(com.oa.model.Person)
	 */
	/* (non-Javadoc)
	 * @see com.oa.dao.impl.PersonDao#addPerson(com.oa.model.Person)
	 */
	public Serializable addPerson(Person person){
		return superDao.add(person);
	}
	
	/* (non-Javadoc)
	 * @see com.oa.dao.impl.PersonDao#delete(com.oa.model.Person)
	 */
	/* (non-Javadoc)
	 * @see com.oa.dao.impl.PersonDao#delete(com.oa.model.Person)
	 */
	public void delete(Person person){
		superDao.delete(person);
	}
	
	/* (non-Javadoc)
	 * @see com.oa.dao.impl.PersonDao#update(com.oa.model.Person)
	 */
	/* (non-Javadoc)
	 * @see com.oa.dao.impl.PersonDao#update(com.oa.model.Person)
	 */
	public void update(Person person){
		superDao.update(person);
	}
	
	/* (non-Javadoc)
	 * @see com.oa.dao.impl.PersonDao#getPerson(java.io.Serializable)
	 */
	/* (non-Javadoc)
	 * @see com.oa.dao.impl.PersonDao#getPerson(java.lang.Class, java.io.Serializable)
	 */
	public Person getPerson(Class clazz,Serializable id){
		return (Person) superDao.select(clazz, id);
	}
	
	/* (non-Javadoc)
	 * @see com.oa.dao.impl.PersonDao#getAllPersons(java.lang.Class, java.lang.String)
	 */
	public List<Person> getAllPersons(Class clazz,String hql){
		return objectToList(superDao.getAllObjects(Person.class, hql));
	}
	
	private List<Person> objectToList(List<Object> list){
		List<Person> persons=new ArrayList<Person>();
		for(Object o: list){
			persons.add((Person)o);
		}
		return persons;
	}
	
	/* (non-Javadoc)
	 * @see com.oa.dao.impl.PersonDao#getPagePerson(java.lang.Class, java.lang.String)
	 */
	public List<Person> getPagePerson(int index,Class clazz, String hql){
		return objectToList(superDao.getPage(index, clazz, hql));
	}

	public SuperDaoInte getSuperDao() {
		return superDao;
	}

	@Resource
	public void setSuperDao(SuperDaoInte superDao) {
		this.superDao = superDao;
	}

	public void deletePersons(Class clazz,String[] ids,String hql) {
		superDao.deleteList(clazz, ids,hql);
	}
}
