package com.test;

import org.junit.Test;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysRegister;
import com.hm.sys.service.SysRegisterService;


public class TestSysRegisterService extends TestBase{

	@Test
	public void testFindPageObjects(){
		SysRegisterService ServiceImpl
		= ctx.getBean("sysRegisterServiceImpl",SysRegisterService.class);
		PageObject<SysRegister> PO = ServiceImpl.findPageObjects(0, 1);
		System.out.println(PO.getRecords().size()+
				";"+PO.getRowCount()+
				";"+PO.getPageCount());
	}
}
