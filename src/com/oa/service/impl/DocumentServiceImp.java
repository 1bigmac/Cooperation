package com.oa.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oa.dao.DocumentDao;
import com.oa.model.Document;
import com.oa.service.DocumentService;
@Component("documentService")
public class DocumentServiceImp implements DocumentService {
	
	private DocumentDao documentDao;

	/*
	 *  添加公文信息
	 * @param document 公文对象
	 * @param workflowId 公文对应的流程ID
	 * @param userId 公文的创建者ID
	 */
	/* (non-Javadoc)
	 * @see com.oa.service.impl.DocumentService#addDocument(com.oa.model.Document, int, int)
	 */
	public void addDocument(Document document,int workflowId,int userId){
		documentDao.addDocument(document, workflowId, userId);
	}
	
	/* (non-Javadoc)
	 * @see com.oa.service.impl.DocumentService#updateDocument(com.oa.model.Document, int, int)
	 */
	public void updateDocument(Document document,int workFLowId,int userId){
		documentDao.updateDocument(document, workFLowId, userId);
	}
	/* (non-Javadoc)
	 * @see com.oa.service.impl.DocumentService#getDocument(java.io.Serializable)
	 */
	public Document findDocument(Serializable id){
		return documentDao.getDocument(id);
	}
	
	/* (non-Javadoc)
	 * @see com.oa.service.impl.DocumentService#searchApprovedDocuments(int)
	 */
	public List<Document> searchApprovedDocuments(int userId){
		String hql="select distinct h.document from ApproveHistory h where h.approver.id="+userId;
		return documentDao.searchApprovedDocuments(userId);
//		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.oa.service.impl.DocumentService#searchApprovingDocuments(int)
	 */
	public List<Document> searchApprovingDocuments(int userId){
		return documentDao.searchApprovingDocuments(userId);
	}
	
	public List<Document> searchMyDocuments(int index, int userId){
		return documentDao.searchMyDocumentPages(Document.class, userId, index);
	}
	
	/* (non-Javadoc)
	 * @see com.oa.service.impl.DocumentService#deleteDocument(com.oa.model.Document)
	 */
	public void deleteDocument(Document document){
		documentDao.deleteDocument(document);
	}
	
	/**
	 * 查询下一个可选步骤列表（公文ID，用户标识）
	 * @param documentId
	 * @param userId
	 * @return
	 */
	public List searchNextStep(int documentId,int userId){
		return documentDao.searchNextStep(documentId, userId);
	}
	
//	/* (non-Javadoc)
//	 * @see com.oa.service.impl.DocumentService#getAllDocuments(java.lang.Class, java.lang.String)
//	 */
//	public List<Document> getAllDocuments(Class clazz, String hql){
//		return documentDao.getAllDocuments(clazz, hql);
//	}
	
	/* (non-Javadoc)
	 * @see com.oa.service.impl.DocumentService#getPageDocuments(int, java.lang.Class, java.lang.String)
	 */
//	public List<Document> getPageDocuments(int index, Class clazz, String hql){
//		return documentDao.getPageDocuments(index, clazz, hql);
//	}
//	
	/* (non-Javadoc)
	 * @see com.oa.service.impl.DocumentService#submitToWorkFlow(int, int, java.lang.String)
	 */
	public void submitToWorkFlow(int userId,int documentId,String transistionName){
		documentDao.submitToWorkFlow(userId, documentId, transistionName);
	}

	public DocumentDao getDocumentDao() {
		return documentDao;
	}

	@Resource
	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}

}
