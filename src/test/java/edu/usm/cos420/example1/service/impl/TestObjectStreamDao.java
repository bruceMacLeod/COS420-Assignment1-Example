package edu.usm.cos420.example1.service.impl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.usm.cos420.example1.domain.CItem;

public class TestObjectStreamDao {

	ObjectStreamDao dao; 
	
/** 
 * Create a clean DAO before each test
 */
	@Before
	public void setupData() {
	   dao = new ObjectStreamDao("_test.ser");
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
	
	/** 
	 * Need to delete the file for next test
	 */
	@After
	public void tearDown()
	{

		Path path = FileSystems.getDefault().getPath(".", "_test.ser");
		try {
		    Files.delete(path);
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", path);
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", path);
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}
	}
	
}
