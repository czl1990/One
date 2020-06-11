package com.test;

import java.util.List;

import org.junit.Test;

import com.hm.sys.dao.SysRoomtypeDao;
import com.hm.sys.entity.SysRoomtype;


public class TestSysRoomtypeDao extends TestBase {

	@Test
	public void testGetRowCount(){
		SysRoomtypeDao dao = 
				ctx.getBean("sysRoomtypeDao", SysRoomtypeDao.class);
		int rowCount = 
				dao.getRowCount("");
		System.out.println("rowCount="+rowCount);
	}

	@Test
	public void testFindPageObjects(){
		SysRoomtypeDao dao = 
				ctx.getBean("sysRoomtypeDao", SysRoomtypeDao.class);
		List<SysRoomtype> list= 
				dao.findPageObjects("", 0, 20);
		for(SysRoomtype sr : list)
		System.out.println(sr);
	}
	
}
