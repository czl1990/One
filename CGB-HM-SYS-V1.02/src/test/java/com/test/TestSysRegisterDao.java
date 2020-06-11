package com.test;

import java.util.List;

import org.junit.Test;

import com.hm.sys.dao.SysRegisterDao;
import com.hm.sys.entity.SysRegister;


public class TestSysRegisterDao extends TestBase {

	@Test
	public void testGetRowCount(){
		SysRegisterDao dao = 
				ctx.getBean("sysRegisterDao", SysRegisterDao.class);
		int rowCount = 
				dao.getRowCount(0);
		System.out.println("rowCount="+rowCount);
	}

	@Test
	public void testFindPageObjects(){
		SysRegisterDao dao = 
				ctx.getBean("sysRegisterDao", SysRegisterDao.class);
		List<SysRegister> list= 
				dao.findPageObjects(0, 0, 10);
		for(SysRegister sr : list)
		System.out.println(sr);
	}
	
	
}
