package com.oa.service.impl;

import java.io.Serializable;
import java.util.List;

import com.oa.model.Document;

public class DocumentServiceImp {

	/*
	 *  添加公文信息
	 * @param document 公文对象
	 * @param workflowId 公文对应的流程ID
	 * @param userId 公文的创建者ID
	 */
	public void addDocument(Document document,int workflowId,int userId){
		
	}
	
	/**
	 * 更新公文信息
	 * @param document
	 */
	public void updateDocument(Document document,int workFLowId,int userId){
		
	}
	/**
	 * 查找某个公文
	 * @param id
	 * @return
	 */
	public Document getDocument(Serializable id){
		
		return null;
	}
	
	/**
	 * 查询(当前登录用户的)已审公文列表
	 * @param userId 用户ID，取当前登录用户的ID
	 * @return
	 */
	public List<Document> searchApprovedDocuments(int userId){
		return null;
	}
	
	/**
	 * 查询待审（即等待当前登录用户审批的）公文列表
	 * @param userId 当前登录用户的ID
	 * @return
	 */
	public List<Document> searchApprovingDocuments(int userId){
		
		return null;
	}
	
	/**
	 *  删除公文信息
	 * @param document
	 */
	public void deleteDocument(Document document){
		
	}
	
	/**
	 * 
	 *  * 搜索我的公文列表（即搜索由当前登录用户创建的公文列表）
	 * @param clazz
	 * @param hql
	 * @return
	 */
	public List<Document> getAllDocuments(Class clazz, String hql){
		return null;
	}
	
	/**
	 * 
	 *  * 分页搜索我的公文列表（即搜索由当前登录用户创建的公文列表）
	 * @param clazz
	 * @param hql
	 * @return
	 */
	public List<Document> getPageDocuments(int index, Class clazz, String hql){
		return null;
	}
	
	/**

	public List searchNextStep(int documentId,int userId){
		
		return null;
	}
	
	/**
	 * 提交到流程
	 * @param userId 当前登录用户的ID
	 * @param documentId 被提交的公文ID
	 * @param transistionName 要提交到哪里去
	 */
	public void submitToWorkFlow(int userId,int documentId,String transistionName){
		
	}
}
