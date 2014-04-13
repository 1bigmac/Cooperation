package com.oa.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.jbpm.JbpmContext;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.def.Transition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.stereotype.Component;
import org.springmodules.workflow.jbpm31.JbpmTemplate;

import com.oa.dao.JbpmCore;
import com.oa.model.Document;
@Component("jbpmCore")
public class JbpmCoreImp implements JbpmCore {

	private JbpmTemplate jbpmTemplate;
//	private ProcessDefinition processDefinition;

	/**
	 * 添加流程实例
	 * @param processName 流程实例对应的流程名称
	 * @param docId 公文ID
	 * @return 流程实例
	 * @see com.oa.dao.impl.JbpmCore#addProcessInstance(java.lang.String,
	 * com.oa.model.Document)
	 */
	public Long addProcessInstance(String processname, Document document) {
		// processDefinition=ProcessDefinition.parseXmlReader(reader);
		JbpmContext context = getJbpmContext();

		
		ProcessDefinition definition = context.getGraphSession()
				.findLatestProcessDefinition(processname);
		ProcessInstance instance = new ProcessInstance(definition);
		//add
		instance.getContextInstance().setVariable("document", document.getId());
		
		//将公文标题也提交到流程实例变量中，以便在E-Mail中能够提示这个公文的名称
		instance.getContextInstance().setVariable("docTitle", document.getTitle());
		
		//将公文的相关属性设置进入流程实例变量
//		Map props = document.getProperties();
//		if(props != null){
//			Set entries = props.entrySet();
//			for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
//				Map.Entry entry = (Map.Entry) iterator.next();
//				String propertyName = (String)entry.getKey();
//				Object obj = document.getProperty(propertyName);
//				//将变量放入流程实例变量
//				instance.getContextInstance().setVariable(propertyName, obj);
//			}
//		}
		context.save(instance);
		context.close();
		// email 没写
		return instance.getId();
	}

	/**
	 * 删除流程实例对象
	 * @param processInstanceId 删除流程实例对象
	 * @see com.oa.dao.impl.JbpmCore#deleteProcessInstance(java.lang.Long)
	 */
	public void deleteProcessInstance(Long processInstance) {
		JbpmContext context = getJbpmContext();
		context.getGraphSession().deleteProcessInstance(processInstance);
		context.close();
	}

	/**
	 * 删除流程定义
	 * @param processName 流程名称
	 * @see com.oa.dao.impl.JbpmCore#deleteProcessDefinition(java.lang.String)
	 */
	public void deleteProcessDefinition(String processname) {
		JbpmContext context = getJbpmContext();
		List<ProcessDefinition> defiList = context.getGraphSession()
				.findAllProcessDefinitionVersions(processname);
		for (ProcessDefinition object : defiList) {
			context.getGraphSession().deleteProcessDefinition(object);
		}
		context.close();
	}

	/*
	 * (non-Javadoc) 部署流程定义
	 * 
	 * @see com.oa.dao.impl.JbpmCore#deployProcessDefinition(byte[])
	 */
	public String deployProcessDefinition(byte[] processdefintion) {
//		processDefinition = ProcessDefinition.parseXmlInputStream(new ByteArrayInputStream(processdefintion));
		JbpmContext context=getJbpmContext();
		ProcessDefinition processDefinition = ProcessDefinition.parseXmlInputStream(new ByteArrayInputStream(processdefintion));
		context.deployProcessDefinition(processDefinition);
		context.close();
		return processDefinition.getName();
	}
	public String deployProcessDefinition(String processdefintion) throws FileNotFoundException {
		System.err.println("jbpmCoreImp");
		JbpmContext context=getJbpmContext();
//		processDefinition = ProcessDefinition.parseXmlInputStream(new ByteArrayInputStream(processdefintion));
		ProcessDefinition processDefinition = ProcessDefinition.parseXmlInputStream(new FileInputStream(new File(processdefintion)));
		if(context==null){
			System.out.println(" context is null");
		}
		context.deployProcessDefinition(processDefinition);
		context.close();
		return processDefinition.getName();
	}

	/**
	 * 触发JBPM引擎流转到下一步
	 * @param processInstanceId 流程实例标识
	 * @param actorId 用户帐号
	 * @param transitionName transition Name
	 * @return 流转之后，当前流程实例所对应的rootToken所指向的节点的名称
	 * @see com.oa.dao.impl.JbpmCore#nextStep(java.lang.Long, java.lang.String,
	 * java.lang.String)
	 */
	public String nextStep(Long processInstance, String actorId,
			String transitionName) {
		JbpmContext context = getJbpmContext();
		ProcessInstance instance = context.getProcessInstance(processInstance);
		// 获取当前接点
		String currentNodeName = instance.getRootToken().getNode().getName();
		// 获取起点的名称
		String startNodeName = instance.getProcessDefinition().getStartState()
				.getName();
		if (startNodeName.equals(currentNodeName)) {
			if (transitionName == null) {
				instance.signal();
			} else {
				instance.signal(transitionName);
			}
		} else {
			List<TaskInstance> taskInstances = context.getTaskMgmtSession()
					.findTaskInstances(actorId);
			for (TaskInstance taskInstance : taskInstances) {
				if (taskInstance.getProcessInstance().getId() == processInstance) {
					if (transitionName == null) {
						taskInstance.end();
					} else {
						taskInstance.end(transitionName);
					}
					break;
				}
			}
			List pooledTaskInstances = context.getTaskMgmtSession()
					.findPooledTaskInstances(actorId);
			for (Iterator iterator = pooledTaskInstances.iterator(); iterator
					.hasNext();) {
				TaskInstance ti = (TaskInstance) iterator.next();
				if (ti.getProcessInstance().getId() == processInstance) {
					if (transitionName == null) {
						ti.end();
					} else {
						ti.end(transitionName);
					}
					break;
				}
			}
		}
		
		return instance.getRootToken().getNode().getName();
	}

	/**
	 * 回退操作
	 * 
	 * @param processInstanceId 流程实例标识
	 * @param actorId 参与者
	 * @return 长度为2的数组，第一个值是转向之后的节点名称，第二个值是流程实例标识
	 * @see com.oa.dao.impl.JbpmCore#backStep(java.lang.Long, java.lang.String)
	 */
	public Object[] backStep(Long processInstanceID, String actorID) {
		JbpmContext context = getJbpmContext();
		Object[] os = new Object[2];
		ProcessInstance instance = context
				.getProcessInstance(processInstanceID);
		List<TaskInstance> taskInstances = context.getTaskMgmtSession()
				.findTaskInstances(actorID);
		for (TaskInstance taskInstance : taskInstances) {
			if (taskInstance.getProcessInstance().getId() == processInstanceID) {
				Set set = taskInstance.getToken().getNode()
						.getArrivingTransitions();
				for (Iterator iterator = set.iterator(); iterator.hasNext();) {
					Transition transition = (Transition) iterator.next();
					// 如果它需要回退到起点
					if (transition.getFrom().equals(
							taskInstance.getProcessInstance()
									.getProcessDefinition().getStartState())) {
						int docId = (Integer) taskInstance.getProcessInstance()
								.getContextInstance().getVariable("document");
						// 结束当前的流程实例
						taskInstance.getProcessInstance().end();
						// 结束当前任务实例
						taskInstance.end();
						// 重新创建流程实例对象

						ProcessInstance processInstance = new ProcessInstance(
								taskInstance.getProcessInstance()
										.getProcessDefinition());
						context.save(processInstance);
						os[0] = "新建";
						os[1] = processInstance.getId();

						return os;
					}
				}
				// 如果不需要回退到起点
				taskInstance.end("回退");
			}
		}
		os[0] = instance.getRootToken().getNode().getName();
		os[1] = processInstanceID;
		return os;
	}

	/**
	 * 搜索某个用户手上的公文列表
	 * @param actorId 用户帐号
	 * @return List中的元素是docId
	 * @see com.oa.dao.impl.JbpmCore#seachMyTaskList(java.lang.String)
	 */
	public List<Integer> seachMyTaskList(String actorID) {
		JbpmContext context = getJbpmContext();
		List documents = new ArrayList();

		List<TaskInstance> taskInstances = context.getTaskMgmtSession()
				.findTaskInstances(actorID);
		for (TaskInstance instance : taskInstances) {
			Integer docid = (Integer) instance.getProcessInstance()
					.getContextInstance().getVariable("document");
			documents.add(docid);
		}
		// 查找所属组的任务实例
		List pooledTaskInstances = context.getTaskMgmtSession()
				.findPooledTaskInstances(actorID);
		for (Iterator iterator = pooledTaskInstances.iterator(); iterator
				.hasNext();) {
			TaskInstance ti = (TaskInstance) iterator.next();
			Integer docid = (Integer) ti.getProcessInstance()
					.getContextInstance().getVariable("document");
			documents.add(docid);
		}

		return documents;
	}

	/**
	 * 查询下一步Transition列表
	 * @param processInstanceId 流程实例标识
	 * @param actorId 用户帐号
	 * @return List中的元素是Transition对象的名称
	 * @see com.oa.dao.impl.JbpmCore#searchNextTransitions(java.lang.Long)
	 */
	public List searchNextTransitions(Long processInstanceId , String actorId) {
		JbpmContext context = getJbpmContext();
		ProcessInstance instance = context.getProcessInstance(processInstanceId);
		
		//当前节点
		String currentNodeName = instance.getRootToken().getNode().getName();
		
		//起点的名称
		String startNodeName = instance.getProcessDefinition().getStartState().getName();
		
		Collection transitions = null;
		
		//如果是在起点
		if(startNodeName.equals(currentNodeName)){
			transitions = instance.getRootToken().getAvailableTransitions();
		}else{
			List taskInstances = context.getTaskMgmtSession().findTaskInstances(actorId);
			for (Iterator iterator = taskInstances.iterator(); iterator
					.hasNext();) {
				TaskInstance ti = (TaskInstance) iterator.next();
				if(ti.getProcessInstance().getId() == processInstanceId){
					transitions = ti.getAvailableTransitions();
					break;
				}
			}
			
			//查找所属组的任务实例
			List pooledTaskInstances = context.getTaskMgmtSession().findPooledTaskInstances(actorId);
			for (Iterator iterator = pooledTaskInstances.iterator(); iterator
					.hasNext();) {
				TaskInstance ti = (TaskInstance) iterator.next();
				if(ti.getProcessInstance().getId() == processInstanceId){
					transitions = ti.getAvailableTransitions();
				}
			}
		}
		
		List transitionNames = new ArrayList();
		
		if(transitions != null){
			//为了不把Transition对象直接暴露给OA系统，需要将其转换为名称列表
			for (Iterator iterator = transitions.iterator(); iterator.hasNext();) {
				Transition transition = (Transition) iterator.next();
				transitionNames.add(transition.getName());
			}
		}
		
		return transitionNames;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.oa.dao.impl.JbpmCore#setJbpmTemplate(org.springmodules.workflow.jbpm31
	 * .JbpmTemplate)
	 */
	@Resource
	public void setJbpmTemplate(JbpmTemplate jbpmTemplate) {
		this.jbpmTemplate = jbpmTemplate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oa.dao.impl.JbpmCore#getJbpmTemplate()
	 */
	public JbpmTemplate getJbpmTemplate() {
		return jbpmTemplate;
	}

	private JbpmContext getJbpmContext() {
		return jbpmTemplate.getJbpmConfiguration().createJbpmContext();
	}
}
