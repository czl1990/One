package com.test;

import java.util.List;

import org.junit.Test;

import com.hm.sys.dao.SysBillDao;
import com.hm.sys.entity.SysBill;


public class TestSysBillDao extends TestBase {

	@Test
	public void testGetRowCount(){
		SysBillDao dao = 
				ctx.getBean("sysBillDao", SysBillDao.class);
		int rowCount = 
				dao.getRowCount(0);
		System.out.println("rowCount="+rowCount);
	}

	@Test
	public void testFindPageObjects(){
		SysBillDao dao = 
				ctx.getBean("sysBillDao", SysBillDao.class);
		List<SysBill> list= 
				dao.findPageObjects(0, 0, 3);
		for(SysBill sr : list)
		System.out.println(sr);
	}
	
}
