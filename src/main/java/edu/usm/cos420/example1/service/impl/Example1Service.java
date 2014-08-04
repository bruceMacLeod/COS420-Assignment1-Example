package edu.usm.cos420.example1.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.domain.CItem;
import edu.usm.cos420.example1.domain.util.PersistentObject;
import edu.usm.cos420.example1.exceptions.DaoException;

public class Example1Service {

	private GenericDao cItemDao;

	public GenericDao getCItemDao() {
		return cItemDao;
	}

	public void setCItemDao(GenericDao dao) {
		this.cItemDao = dao;
	}
	
	public void addCItem(CItem entity) 
	{
		cItemDao.add(entity);
	}


	public void updateCItem(CItem entity) {
        cItemDao.update(entity);
	}

	public void removeCitem(CItem entity) {
		cItemDao.remove(entity);
	}

	public CItem findCItem(Long key) {
		return (CItem) cItemDao.find(key);
	}

	public ArrayList<CItem> listCItems() {
		return (ArrayList<CItem>)(cItemDao.list());
	}


}
