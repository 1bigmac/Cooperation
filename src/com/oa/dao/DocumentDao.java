package com.oa.dao;

import java.io.Serializable;
import java.util.List;

import com.oa.model.Document;

public interface DocumentDao {

	/*
	 *  添加公文信息
	 * @param document 公文对象
	 * @param workflowId 公文对应的流程ID
	 * @param userId 公文的创建者ID
	 */
	public abstract void addDocument(Document document, int workflowId,
			int userId);

	/**
	 * 更新公文信息
	 * @param document
	 */
	public abstract void updateDocument(Document document, int workFLowId,
			int userId);

	/**
	 * 查找某个公文
	 * @param id
	 * @return
	 */
	public abstract Document getDocument(Serializable id);



	/**
	 * 查询待审（即等待当前登录用户审批的）公文列表
	 * @param userId 当前登录用户的ID
	 * @return
	 */
	public abstract List<Document> searchApprovingDocuments(int userId);

	/**
	 *  删除公文信息
	 * @param document
	 */
	public abstract void deleteDocument(Document document);

	/**
	 * 
	 *  * 搜索我的公文列表（即搜索由当前登录用户创建的公文列表）
	 * @param clazz
	 * @param hql
	 * @return
	 */
	public List<Document> searchMyDocumentPages(Class clazz,int userId,int index);
	
	
	public abstract List<Document> getAllDocuments(Class clazz, String hql);

	/**
	 * 
	 *  * 分页搜索我的公文列表（即搜索由当前登录用户创建的公文列表）
	 * @param clazz
	 * @param hql
	 * @return
	 */
	public abstract List<Document> getPageDocuments(int index, Class clazz,
			String hql);

	/**
	 * 查询(当前登录用户的)已审公文列表
	 * @param userId 用户ID，取当前登录用户的ID
	 * @return
	 */
	public abstract List<Document> searchApprovedDocuments(int userId);
	
	public List searchNextStep(int documentId,int userId);
	
	/**
	 * 提交到流程
	 * @param userId 当前登录用户的ID
	 * @param documentId 被提交的公文ID
	 * @param transistionName 要提交到哪里去
	 */
	public abstract void submitToWorkFlow(int userId, int documentId,
			String transistionName);
}
