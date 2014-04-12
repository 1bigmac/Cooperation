package com.oa.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 公文
 * @author Big mac
 *
 */

@Entity
@Table(name="oa_document")
public class Document implements Serializable{
	/**
	 * 文档 id
	 */
	private Integer id;
	/**
	 * 文档标题
	 */
	private String title;
	/**
	 * 文档内容
	 */
	private byte []Content;
	/**
	 * 文档描述
	 */
	private String description;
	/**
	 * 文档创建时间
	 */
	private Date createTime;
	/**
	 * 文档状态
	 */
	private String status;
	/**
	 * 创建者
	 */
	private Users users;
	/**
	 * 所属工作流程
	 */
	private WorkFlow workFlow;
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getContent() {
		return Content;
	}
	public void setContent(byte[] content) {
		Content = content;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinColumn(name="creator", referencedColumnName="id")
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinColumn(name="workflow",referencedColumnName="id")
	public WorkFlow getWorkFlow() {
		return workFlow;
	}
	public void setWorkFlow(WorkFlow workFlow) {
		this.workFlow = workFlow;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", title=" + title + ", Content="
				+ Arrays.toString(Content) + ", description=" + description
				+ ", createTime=" + createTime + ", status=" + status + "]";
	}
}
