package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.oa.dao.ApproveHistoryDao;
import com.oa.model.ApproveHistory;
import com.oa.service.ApproveHistoryService;

public class ApproveHistoryServiceImp implements ApproveHistoryService {
	private ApproveHistoryDao approveHistoryDao;
	
	/* (non-Javadoc)
	 * @see com.oa.service.impl.ApproveHistoryService#addApproveHistory(com.oa.model.ApproveHistory, int, int, boolean)
	 */
	public void addApproveHistory(ApproveHistory approveInfo,int documentId,int approverId,boolean back){
		approveHistoryDao.addApproveHistory(approveInfo, documentId, approverId, back);
	}
	
	
	/* (non-Javadoc)
	 * @see com.oa.service.impl.ApproveHistoryService#searchApproveHistory(int)
	 */
	public List<ApproveHistory> searchApproveHistory(int documentId){
		return approveHistoryDao.searchApproveHistory(documentId);
	}



	public ApproveHistoryDao getApproveHistoryDao() {
		return approveHistoryDao;
	}



	@Resource
	public void setApproveHistoryDao(ApproveHistoryDao approveHistoryDao) {
		this.approveHistoryDao = approveHistoryDao;
	}

}
