package com.oa.action;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.junit.runner.Request;

import com.oa.model.Person;
import com.oa.model.Users;
import com.oa.service.PersonService;
import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport {

	private Person person;
	private Users user;
	private PersonService personService;
	private int index;
	private String returns;
	
	public String edit(){
		System.out.println(person.getId());
		Person temPerson=personService.getPerson(person.getId());
		ServletActionContext.getRequest().setAttribute("person", temPerson);
		System.out.println(temPerson.toString());
		return "edit";
	}

	public String addUser() {
		if (person.getId() == null) {
			autoConvertToAge();
			Serializable flag = personService.addPerson(person);
			returns="JSP/yuangong.jsp";
			System.out.println(person.toString()+" personAction  test");
			return flag == null ? "operator_failure" : "operator_success";
		} else {
			returns="PersonAction!personList";
			System.err.println(returns);
			autoConvertToAge();
			personService.updatePerson(person);
		}
		return "operator_success";
	}

	private void autoConvertToAge() {
		Date now =new Date ();
		Long nowTime=now.getTime();
		Long birthtime=person.getBirthday().getTime();
		Long difference=nowTime-birthtime;
		Long differenceDay=difference/(1000*60*60*34);
		person.setAge((int) (differenceDay/365+1));
	}

	
	public String personList(){
		System.out.println("index +  ===="+index);
		String hql ="";
		List<Person> persons=personService.getPagePersons((index==0 ? 1 : index), Person.class, hql);
		HttpServletRequest  request=ServletActionContext.getRequest();
		request.setAttribute("personList", persons);
		request.setAttribute("currentIndex", (index==0 ?  1 : index ));
		int total=personService.getAllPersons(Person.class, hql).size();
		request.setAttribute("totalSize",total);
		
		return SUCCESS;
	}

	public String deletePerson(){
		returns="PersonAction!personList";
		System.out.println("deleteperson");
		HttpServletRequest request=ServletActionContext.getRequest();
		String []ids=request.getParameterValues("delid");
		for (int i = 0; i < ids.length; i++) {
			System.out.println(ids[i]);
		}
		personService.deletePersons(ids);
		return "operator_success";
	}
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public PersonService getPersonService() {
		return personService;
	}

	@Resource
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getReturns() {
		return returns;
	}

	public void setReturns(String returns) {
		this.returns = returns;
	}
}
