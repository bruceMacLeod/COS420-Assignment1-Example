package edu.usm.cos420.example1.dao;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.domain.CItem;

public interface CItemDao extends GenericDao
{

	boolean removeCItem(CItem citem);
}

