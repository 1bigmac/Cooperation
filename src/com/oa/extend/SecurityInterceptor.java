package com.oa.extend;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

import org.apache.struts2.ServletActionContext;

import com.oa.action.UserAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SecurityInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8181217632709500253L;

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("heare mad dan ");
		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletRequest request=ServletActionContext.getRequest();
		System.err.println(request.getRequestURL());
		String machter="UserAction!login";
		String clazz=invocation.getAction().getClass().getName();
		System.out.println(clazz);
		if(UserAction.class.getName().equals(clazz)){
			return invocation.invoke();
		}
		if (session.getAttribute("admin") == null ){
			System.err.println("not exists");
			return Action.LOGIN;
		}else {
			System.out.println("ok next");
			return invocation.invoke();
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

}