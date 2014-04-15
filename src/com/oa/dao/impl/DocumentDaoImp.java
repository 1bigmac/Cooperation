package com.oa.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.ListModel;

import org.springframework.stereotype.Component;

import com.oa.dao.DocumentDao;
import com.oa.dao.JbpmCore;
import com.oa.model.Document;
import com.oa.model.Users;
import com.oa.model.WorkFlow;

@Component("documentDao")
public class DocumentDaoImp implements DocumentDao {
	private SuperDao superDao;
	private JbpmCore jbpmCore;

	public void addDocument(Document document, int workflowId, int userId) {
		// TODO Auto-generated method stub
		WorkFlow wf = (WorkFlow) superDao.select(WorkFlow.class, workflowId);
		Users users = (Users) superDao.select(Users.class, userId);

		Long processInstance = jbpmCore.addProcessInstance(wf.getName(),
				document);
		System.err.println("processInstance  " + processInstance);

		System.err.println(wf.toString());
		System.err.println(users.toString());
		document.setWorkFlow(wf);
		document.setUsers(users);
		document.setProcessInstanceId(processInstance);
		document.setStatus(Document.New);
		document.setCreateTime(new Date());
		superDao.add(document);
	}
	
	public void deleteDocuments(Class clazz,String[] ids,String hql){
		superDao.deleteList(clazz, ids, hql);
	}

	public void updateDocument(Document document, int workFLowId, int userId) {
		// TODO Auto-generated method stub

	}

	public Document getDocument(Serializable id) {
		return (Document) superDao.select(Document.class, id);
	}

	// 查找正在等待审批的公文
	public List<Document> searchPageApprovingDocuments(String username ,int index) {
//		Users users = (Users) superDao.select(Users.class, userId);
//		String temp = users.getPersonid().getName();
		List<Integer> docs = jbpmCore.seachMyTaskList(username);
		System.out.println(docs.size()+"DocumentDaoImp  sdfsaf ");
		if (docs.size() == 0 || docs == null) {
			return null;
		}
	
		String hql = "from Document d where d.id in (:ids)";
		String sign = "ids";
//		return objectToDocuments(superDao.getChoice(docs, hql, sign));
		return objectToDocuments(superDao.getPageChoice(docs, hql, sign, index));
	}
	public List<Document> searchAllApprovingDocuments(String username){
		List<Integer> docs = jbpmCore.seachMyTaskList(username);
		if (docs.size() == 0 || docs == null) {
			return null;
		}
		System.out.println(docs.size()+"DocumentDaoImp  sdfsaf ");
		String hql = "from Document d where d.id in (:ids)";
		String sign = "ids";
		return objectToDocuments(superDao.getChoice(docs, hql, sign));
	}

	// 查找用户已审批过全部的公文
		public List<Document> searchAllApprovedDocuments(String CompleteHql) {
//			return objectToDocuments(superDao
//					.select("select distinct h.document from ApproveHistory h where h.approver.id="
//							+ userId));
			return objectToDocuments(superDao.getAllObjects(CompleteHql));
		}
		// 分页显示审批过的公文
		public List<Document> searchPageApprovedDocument(int index,String CompleteHql){
			return objectToDocuments(superDao.getpage(index, CompleteHql));
		}

	private List<Document> objectToDocuments(List<Object> lists) {
		List<Document> documents = new ArrayList<Document>();
		for (Object o : lists) {
			documents.add((Document) o);
		}
		return documents;
	}

	public void deleteDocument(Document document) {
		superDao.delete(document);
	}

	/**
	 * 我的所有公文
	 */
	public List<Document> searchAllMyDocument(Class clazz, int userId) {
		String hql = "from Document d where d.users.id =" + userId;
		return objectToDocuments(superDao.getAllObjects(hql));
	}
	public List<Document> searchPageDocument(Class clazz, int userId,int index){
		String hql = "from Document d where d.users.id =" + userId;
		return objectToDocuments(superDao.getpage(index, hql));
	}

	// 查找用户创建的所有公文
	public List<Document> getAllDocuments(Class clazz, String hql) {
		return objectToDocuments(superDao.getAllObjects(clazz, hql));
	}

	// 分页查找用户创建的所有公文
	public List<Document> getPageDocuments(int index, Class clazz, String hql) {
		return objectToDocuments(superDao.getPage(index, clazz, hql));
	}
	
	/**
	 * 
	 */
	public List searchNextStep(int documentId, int userId) {
		Document doc = (Document) superDao.select(Document.class, documentId);
		Users users = (Users) superDao.select(Users.class, userId);
		return jbpmCore.searchNextTransitions(doc.getProcessInstanceId(), users
				.getPersonid().getName());
	}

	public void submitToWorkFlow(int userId, int documentId,
			String transistionName) {
		Users users = (Users) superDao.select(Users.class, userId);
		Document doc = (Document) superDao.select(Document.class, documentId);
		String status = jbpmCore.nextStep(doc.getProcessInstanceId(), users
				.getPersonid().getName(), transistionName);
		doc.setStatus(status);
		superDao.update(doc);
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
