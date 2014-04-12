package com.oa.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.annotation.Resource;

import org.springmodules.workflow.jbpm31.JbpmTemplate;

import com.oa.model.Document;

public interface JbpmCore {

	public abstract Long addProcessInstance(String processname,
			Document document);

	public abstract JbpmTemplate getJbpmTemplate();

	public abstract void deleteProcessDefinition(String processname);

	public abstract void deleteProcessInstance(Long processInstance);

	public abstract String deployProcessDefinition(byte[] processDefinition);
	public String deployProcessDefinition(String processdefintion) throws FileNotFoundException;

	public abstract String nextStep(Long processInstance, String actorId,
			String transitionName);

	public abstract Object[] backStep(Long processInstanceID, String actorID);

	public abstract List seachMyTaskList(String actorID);

	public abstract List searchNextTransitions(Long processInstanceId , String actorId);

	@Resource
	public abstract void setJbpmTemplate(JbpmTemplate jbpmTemplate);

}