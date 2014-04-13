package com.oa.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.oa.model.Document;
import com.oa.model.Users;
import com.oa.service.DocumentService;
import com.opensymphony.xwork2.ActionSupport;

public class DocumentAction extends ActionSupport {

	private DocumentService documentService;
	private int index;

	public String listDocument() {

		return null;
	}

	public String listMyDocument() {
		HttpServletRequest request= ServletActionContext.getRequest();
		Users user = (Users)request.getSession()
				.getAttribute("admin");
		List<Document> documents=documentService.searchMyDocuments((index == 0 ? 1 : index),
				user.getId());
		request.setAttribute("currentIndex", (index==0 ?  1 : index ));
		request.setAttribute("myDocumentList", documents);
		int totals=documentService
		return null;
	}

	public DocumentService getDocumentService() {
		return documentService;
	}

	@Resource
	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}
}
