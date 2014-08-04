package edu.usm.cos420.example1.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.domain.CItem;
import edu.usm.cos420.example1.domain.util.PersistentObject;
import edu.usm.cos420.example1.exceptions.DaoException;

public class ObjectStreamDao implements GenericDao  {
	
	private Map<Long,PersistentObject> entityMap = new TreeMap<Long,PersistentObject>();
    ObjectOutputStream oos;
    String fileName;
    int objectCount; 
    
	public ObjectStreamDao()
	{
		this("noname.ser");
	}
	
	public ObjectStreamDao(String fileName) 
	{
        this.fileName = fileName;
		try {
    		FileOutputStream fos = new FileOutputStream(fileName);
    		oos = new ObjectOutputStream(fos);
            objectCount = 0;
		}
    	catch (FileNotFoundException e) {
    		System.err.println("Could not find "+ fileName + e);   	
    	}
    	catch (IOException e) {
    		System.err.println("Some Error writing to stream " + e);   	
    	}
    	catch (Exception e){
    		System.err.println(e);
    	}	
	}
	
	public void add(PersistentObject entity) {
	   	try {
			oos.writeObject(entity);
			objectCount++;
    	}
    	catch (FileNotFoundException e) {
    		System.err.println("Could not find test.ser " + e);   	
    	}
    	catch (IOException e) {
    		System.err.println("Some Error writing to stream " + e);   	
    	}
    	catch (Exception e){
    		System.err.println(e);
    	}	
	}


	public void update(PersistentObject entity) {
	    entityMap = readStreamIntoMap();
		if (entityMap.get(entity.getId()) == null) 
				throw new DaoException("attempting to update non-existent entity in InMemoryDao");
		entityMap.put(entity.getId(),entity);
		writeMapIntoStream(entityMap);
	}

	public void remove(PersistentObject entity) {
	    entityMap = readStreamIntoMap();
		entityMap.remove(entity.getId());
		writeMapIntoStream(entityMap);
		objectCount--;
	}

	public PersistentObject find(Long key) {
	    entityMap = readStreamIntoMap();
		if (entityMap.isEmpty()) {
			return null;
		}
		return entityMap.get(key);
	}

	public List<PersistentObject> list() {
	    entityMap = readStreamIntoMap();
    	return new ArrayList<PersistentObject> (entityMap.values());    		                     
	}

	private Map<Long, PersistentObject> readStreamIntoMap() {
    	entityMap.clear();

    	try {
    		FileInputStream fis = new FileInputStream(fileName);
    		ObjectInputStream ois = new ObjectInputStream(fis);
    		for (int i = 0;i<objectCount;i++)
    		{
                PersistentObject po = (PersistentObject) ois.readObject();
    			entityMap.put(po.getId(), po);	
    		}
    		ois.close();
    	}   		
    	catch (FileNotFoundException e) {
    		System.err.println("Could not find " + fileName + "  "+ e);   	
    	}
    	catch (IOException e) {
    		System.err.println("Some Error writing to stream " + e);   	
    	}
    	catch (Exception e){
    		System.err.println(e);
    	}	

    	return entityMap;    		                     
	}

	private void writeMapIntoStream(Map<Long, PersistentObject> map) 
	{
    	try {
    		oos.close();
    	}
    	catch (FileNotFoundException e) {
    		System.err.println("Could not find test.ser " + e);   	
    	}
    	catch (IOException e) {
    		System.err.println("Some Error writing to stream " + e);   	
    	}
    	catch (Exception e){
    		System.err.println(e);
    	}	

    	try {
    		FileOutputStream fos = new FileOutputStream(fileName);
    		ObjectOutputStream oos = new ObjectOutputStream(fos);
    		Collection<PersistentObject> poSet = (Collection<PersistentObject>) map.values();
    		Iterator<PersistentObject> iter = poSet.iterator();
    		while (iter.hasNext()) {
        		oos.writeObject(iter.next());
    		}
    	}   		
    	catch (FileNotFoundException e) {
    		System.err.println("Could not find " + fileName + "  "+ e);   	
    	}
    	catch (IOException e) {
    		System.err.println("Some Error writing to stream " + e);   	
    	}
    	catch (Exception e){
    		System.err.println(e);
    	}	

	}

	

}
