package com.oa.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.oa.model.Module;
import com.oa.model.Person;
import com.oa.model.Users;
import com.oa.service.ModuleService;
import com.oa.service.PersonService;
import com.oa.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Big mac
 *
 */
public class UserAction extends ActionSupport {

	private UserService userService;
	private PersonService personService;
	private ModuleService moduleService;
	
	private Users user;
	private String returns;
	
	public String login(){
		System.out.println(user.toString());
		Users login=userService.login("from Users u where u.account = ? and u.password= ?", new Object[]{user.getAccount(),user.getPassword()});
		if(login!=null){
			ServletActionContext.getRequest().getSession().setAttribute("admin", login);
			ServletActionContext.getRequest().getSession().setAttribute("modules", moduleService.getCategories());
			moduleService.getCategories();
			return "login_success";
		}
		return "login_failure";
	}
	
	public String exits(){
		Users exits=userService.exits(user.getAccount());
		return null;
	}
	
	public String selfModify(){
		Users user=(Users) ServletActionContext.getRequest().getSession().getAttribute("admin");
		System.out.println(user.toString());
		System.out.println("=======+++++=====");
		Person person=personService.getPerson(user.getPersonid().getId());
		System.out.println(person.toString());
		ServletActionContext.getRequest().setAttribute("person", person);
		returns="gerenxinxi.jsp";
		return "modify";
	}
	public String accountModify(){
		returns="gerenxinxi.jsp";
		System.out.println(user.toString());
		userService.update(user);
		return "operator_success";
	}
	
	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public String getReturns() {
		return returns;
	}

	public void setReturns(String returns) {
		this.returns = returns;
	}

	public ModuleService getModuleService() {
		return moduleService;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	
	
}
