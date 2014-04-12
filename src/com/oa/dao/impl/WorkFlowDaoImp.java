package com.oa.dao.impl;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oa.dao.JbpmCore;
import com.oa.dao.WorkFlowDao;
import com.oa.model.WorkFlow;

@Component("workFlowDao")
public class WorkFlowDaoImp implements WorkFlowDao {
	private SuperDao superDao;
	private JbpmCore jbpmCore;

	public Serializable addWorkFlow(String processDefinition,
			String processImage) throws FileNotFoundException {
		String workFlowName = jbpmCore
				.deployProcessDefinition(processDefinition);

		WorkFlow wf = new WorkFlow();
		wf.setName(workFlowName);
		wf.setProcessDefinition(processDefinition);
		wf.setProcessImage(processImage);
		return superDao.add(wf);
	}

	public void updateWorkFlow(String processDefinition, String processImage,int id) {
		String workFlowName = "";
		try {
			workFlowName = jbpmCore.deployProcessDefinition(processDefinition);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// 首先根据流程名称，查询是否已有Workflow对象
//		WorkFlow wf = (WorkFlow) superDao.select(
//				"from WorkFlow w where w.name= " + workFlowName).get(0);
		WorkFlow wf=new WorkFlow();
		wf.setId(id);
		// if(wf !=null){
		wf.setProcessDefinition(processDefinition);
		wf.setProcessImage(processImage);
		superDao.update(wf);
		// }
	}

	public void deleteWorkFlow(WorkFlow workFlow) {
		superDao.delete(workFlow);
		jbpmCore.deleteProcessDefinition(workFlow.getName());
	}
	public WorkFlow getWorkFlow(Class clazz,Serializable id){
		return (WorkFlow) superDao.select(clazz, id);
	}

	public WorkFlow findWorkFlow(Class clazz, Serializable id) {
		return (WorkFlow) superDao.select(clazz, id);
	}

	public List<WorkFlow> getAllWorkFlows(Class clazz, String hql) {
		return ObjectToWorkFlow(superDao.getAllObjects(clazz, hql));
	}

	private List<WorkFlow> ObjectToWorkFlow(List<Object> lists) {
		List<WorkFlow> workFlows = new ArrayList<WorkFlow>();
		for (Object o : lists) {
			workFlows.add((WorkFlow) o);
		}
		return workFlows;
	}

	public List<WorkFlow> getPageWorkFlows(int index, Class clazz, String hql) {
		return ObjectToWorkFlow(superDao.getPage(index, clazz, hql));
	}

	public SuperDao getSuperDao() {
		return superDao;
	}

	@Resource
	public void setSuperDao(SuperDao superDao) {
		this.superDao = superDao;
	}

	public JbpmCore getJbpmCore() {
		return jbpmCore;
	}

	@Resource
	public void setJbpmCore(JbpmCore jbpmCore) {
		this.jbpmCore = jbpmCore;
	}

}
