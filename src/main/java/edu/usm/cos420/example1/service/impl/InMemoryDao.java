package edu.usm.cos420.example1.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.domain.util.PersistentObject;
import edu.usm.cos420.example1.exceptions.DaoException;

public class InMemoryDao implements GenericDao  {
	
	private Map<Long,PersistentObject> entityMap = new HashMap<Long,PersistentObject>();

	public void add(PersistentObject entity) 
	{
		entityMap.put(entity.getId(),entity);
	}


	public void update(PersistentObject entity) {
		if (entityMap.get(entity.getId()) == null) 
				throw new DaoException("attempting to update non-existent entity in InMemoryDao");
		entityMap.put(entity.getId(),entity);
	}

	public void remove(PersistentObject entity) {
		entityMap.remove(entity.getId());
	}

	public PersistentObject find(Long key) {
		if (entityMap.isEmpty()) {
			return null;
		}
		return entityMap.get(key);
	}

	public List<PersistentObject> list() {
		return new ArrayList<PersistentObject> (entityMap.values());
	}


}
