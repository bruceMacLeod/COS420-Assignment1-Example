package edu.usm.cos420.example1.domain.util;

import java.io.Serializable;
import java.util.UUID;


public abstract class PersistentObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id; 
    private static Long COUNTER = 0L;
    
    public PersistentObject() {
    	id = generateId();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
		this.id = id;
	}

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof PersistentObject)) return false;
        
        PersistentObject other  = (PersistentObject ) o;
        return id.equals(other.getId());
    }

    public int hashCode() {
        return id.hashCode();
    }

    public int compareTo(Object o) throws ClassCastException {
        if (!(o instanceof PersistentObject))
            throw new ClassCastException("A Persistent object expected.");
          Long oId = ((PersistentObject) o).getId();  
          return (int) (this.getId() - oId);    
        
    }
    
    private Long generateId()
    {
    	return COUNTER++;
    }
    
    private String generateUUID() {
        UUID uuid = java.util.UUID.randomUUID();
        return uuid.toString();
    }

}
