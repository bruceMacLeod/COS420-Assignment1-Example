package edu.usm.cos420.example1.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.usm.cos420.example1.domain.CItem;

public class TestInMemoryDao {

	InMemoryDao dao; 
	
/** 
 * Create a clean DAO before each test
 */
	@Before
	public void setupData() {
	   dao = new InMemoryDao();
	}
	
	@Test
    public void testSaveandFind() {
        Long id; 
        CItem retrievedItem;
        
        CItem oneItem = new CItem(2, "a string"); 
        
        // get PK of first address
        id = oneItem.getId();
        
        dao.add(oneItem);

        retrievedItem = (CItem) dao.find(id);
        
        assertNotNull("Dao returns a null item.", retrievedItem);
        assertEquals("Stored Id and original Id are not equal ", retrievedItem.getId() , oneItem.getId());
        assertEquals("Stored int and original int are not equal ", retrievedItem.getMyInteger() , oneItem.getMyInteger());
        
	}
	

}
