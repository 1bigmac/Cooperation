package com.oa.action;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.oa.model.Organization;
import com.oa.service.OrganizationService;
import com.opensymphony.xwork2.ActionSupport;

public class OrganizationAction extends ActionSupport implements Serializable {
	
	private static final long serialVersionUID = -7331883999194400795L;
	
	private Organization organization;
	private OrganizationService organizationService;
	private List<Organization> listOrg;
	
	public String add() {
		System.out.println("orga.id"+organization.getId());
		
		System.out.println("orga.name"+organization.getName());
		System.out.println("organ.desc"+organization.getDescription());
		organization.setPid(null);
		organization.setSn(null);
		System.out.println("organ. "+organization.getPid());
		System.out.println("organ. "+organization.getSn());
		
		Serializable flag = organizationService.add(organization);
		System.out.println("falg is "+flag);
		if(flag != null) {
			return "add_success";
		} 
		return "add_failure";
	}
	
	public String update() {
		organizationService.update(organization);
		return null;
	}
	
	public String find() {
		listOrg = organizationService.find();
		Organization org = null;
		for(int i=0; i<listOrg.size(); i++) {
			org = new Organization();
			org = listOrg.get(i);
			System.err.println(org.getName());
		}
		return "listOrg";
	}
	public OrganizationService getOrganizationService() {
		return organizationService;
	}
	@Resource
	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public List<Organization> getListOrg() {
		return listOrg;
	}

	public void setListOrg(List<Organization> listOrg) {
		this.listOrg = listOrg;
	}

	@Override
	public String execute() throws Exception {
		return "success";
	}
	
}
