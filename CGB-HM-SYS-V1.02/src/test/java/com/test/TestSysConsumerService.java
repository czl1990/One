package com.test;

import org.junit.Test;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysConsumer;
import com.hm.sys.service.SysConsumerService;


public class TestSysConsumerService extends TestBase{

	@Test
	public void testFindPageObjects(){
		SysConsumerService ServiceImpl
		= ctx.getBean("sysConsumerServiceImpl",SysConsumerService.class);
		PageObject<SysConsumer> PO = ServiceImpl.findPageObjects("", 1);
		System.out.println(PO.getRecords().size()+
				";"+PO.getRowCount()+
				";"+PO.getPageCount());
	}
}
