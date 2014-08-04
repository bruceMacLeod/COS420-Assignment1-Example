package edu.usm.cos420.example1.dao;

import java.util.List;
import edu.usm.cos420.example1.domain.util.PersistentObject;

public interface GenericDao {

	void add(PersistentObject entity);
	
	void update(PersistentObject entity);
	
	void remove(PersistentObject entity);
	
	PersistentObject find(Long key);
    
	List<PersistentObject> list();
	
}
