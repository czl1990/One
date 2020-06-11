package com.test;

import java.util.List;

import org.junit.Test;

import com.hm.sys.dao.SysRoomstateDao;
import com.hm.sys.entity.SysRoomstate;


public class TestSysRoomstateDao extends TestBase {

	@Test
	public void testGetRowCount(){
		SysRoomstateDao dao = 
				ctx.getBean("sysRoomstateDao", SysRoomstateDao.class);
		int rowCount = 
				dao.getRowCount(0);
		System.out.println("rowCount="+rowCount);
	}

	@Test
	public void testFindPageObjects(){
		SysRoomstateDao dao = 
				ctx.getBean("sysRoomstateDao", SysRoomstateDao.class);
		List<SysRoomstate> list= 
				dao.findPageObjects(0, 0, 20);
		for(SysRoomstate sr : list)
		System.out.println(sr);
	}
	
}
