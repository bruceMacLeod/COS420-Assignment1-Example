/*
 * CItem.java
 *
 * Created on August 28, 2001, 11:46 AM
 */

package edu.usm.cos420.example1.domain;

import java.io.Serializable;
import edu.usm.cos420.example1.domain.util.PersistentObject;

/**
 *
 *  For the purposes of this example, CItem holds two 
 *  piece of data. The class implements the interface 
 *  Serializable so that we can store and retrieve the 
 *  information in this class 
 * 
 *  
 */
public class CItem extends PersistentObject implements Serializable {
    
	private static final long serialVersionUID = 7526472295622776147L;
	private Integer myInteger;
    private String myString;
    
	/** Creates new CItem */
    public CItem() {
        myInteger = new Integer(0);
        myString = new String("");
    }

    /** Creates new CItem */
    public CItem(int n,java.lang.String str) {
        myInteger = new Integer(n);
        myString = str;
    }

	/**
	 * @return Returns the Integer.
	 */
	public Integer getMyInteger() {
		return myInteger;
	}
	/**
	 * @param i The integer to set.
	 */
	public void setMyInteger(int i) {
		this.myInteger = new Integer(i);
	}
	/**
	 * @return Returns  myString.
	 */
	public String getMyString() {
		return myString;
	}
	/**
	 * @param myString The string to set.
	 */
	public void setMyString(String myString) {
		this.myString = myString;
	}

    /**
     * Returns the String representation of this User. Not required, it just pleases reading logs.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("CItem [id=%d,myString=%s,myInteger=%s]", getId(), myString, myInteger);
    }

}




