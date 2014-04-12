package com.oa.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oa.dao.ModuleDao;
import com.oa.dao.SuperDaoInte;
import com.oa.model.Module;

@Component("moduleDao")
public class ModuleDaoImp implements ModuleDao {

	private SuperDaoInte superDao;
	static final  Map<Module, Set<Module>> categories = new HashMap<Module, Set<Module>>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.oa.dao.impl.ModuleDao#addModule(com.sun.xml.internal.ws.api.server
	 * .Module)
	 */
	public Serializable addModule(Module module) {

		return superDao.add(module);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.oa.dao.impl.ModuleDao#deleteModule(com.sun.xml.internal.ws.api.server
	 * .Module)
	 */
	public void deleteModule(Module module) {
		superDao.delete(module);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.oa.dao.impl.ModuleDao#updateModule(com.sun.xml.internal.ws.api.server
	 * .Module)
	 */
	public void updateModule(Module module) {
		superDao.update(module);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oa.dao.impl.ModuleDao#getModule(java.io.Serializable)
	 */
	public Module getModule(Serializable id) {
		return (Module) superDao.select(Module.class, id);
	}

	public SuperDaoInte getSuperDao() {
		return superDao;
	}

	@Resource
	public void setSuperDao(SuperDaoInte superDao) {
		this.superDao = superDao;
	}

	public List<Module> getAllModules(Class clazz, String hql) {
		return objectToList(superDao.getAllObjects(clazz, hql));
	}

	public List<Module> getPageModules(int index, Class clazz, String hql) {
		return objectToList(superDao.getPage(index, clazz, hql));
	}

	private List<Module> objectToList(List<Object> list) {
		List<Module> modules = new ArrayList<Module>();

		for (Object o : list) {
			modules.add((Module) o);
		}
		return modules;

	}

	public void deleteModules(Class clazz, String[] ids, String hql) {
		superDao.deleteList(clazz, ids, hql);
	}

	public Map<Module, Set<Module>> getMenus(){
		return categories;
	}

	public void getCategories() {
		if (categories.size()==0) {
			System.err.println("categories is null");
			List<Module> parentModule = getAllModules(Module.class,
					" and s.pid is null");
			System.out.println(parentModule.size() + "pis =null");
			for (int i = 0; i < parentModule.size(); i++) {
				Set<Module> temp = parentModule.get(i).getModules();
				if (temp.size() == 0) {
					categories.put(parentModule.get(i), null);
				} else {
					for (Module children : temp) {
						categories.put(parentModule.get(i), temp);
					}
				}
			}
			// for (Map.Entry<Module, Set<Module>> entry :
			// categories.entrySet()) {
			// System.out.println(entry.getKey().toString());
			// if (entry.getValue() == null) {
			//
			// } else {
			// for (Module m : entry.getValue()) {
			// System.out.println(m.toString());
			// }
		}
	}

}
