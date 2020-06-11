package com.test;

import org.junit.Test;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysRoomtype;
import com.hm.sys.service.SysRoomtypeService;


public class TestSysRoomtypeService extends TestBase{

	@Test
	public void testFindPageObjects(){
		SysRoomtypeService ServiceImpl
		= ctx.getBean("sysRoomtypeServiceImpl",SysRoomtypeService.class);
		PageObject<SysRoomtype> PO = ServiceImpl.findPageObjects("", 1);
		System.out.println(PO.getRecords().size()+
				";"+PO.getRowCount()+
				";"+PO.getPageCount());
	}
}
