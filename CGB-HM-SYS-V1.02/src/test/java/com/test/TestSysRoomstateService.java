package com.test;

import org.junit.Test;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysRoomstate;
import com.hm.sys.service.SysRoomstateService;


public class TestSysRoomstateService extends TestBase{

	@Test
	public void testFindPageObjects(){
		SysRoomstateService ServiceImpl
		= ctx.getBean("sysRoomstateServiceImpl",SysRoomstateService.class);
		PageObject<SysRoomstate> PO = ServiceImpl.findPageObjects(0, 1);
		System.out.println(PO.getRecords().size()+
				";"+PO.getRowCount()+
				";"+PO.getPageCount());
	}
}
