package com.test;

import org.junit.Test;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysBill;
import com.hm.sys.service.SysBillService;


public class TestSysBillService extends TestBase{

	@Test
	public void testFindPageObjects(){
		SysBillService ServiceImpl
		= ctx.getBean("sysBillServiceImpl",SysBillService.class);
		PageObject<SysBill> PO = ServiceImpl.findPageObjects(0, 1);
		System.out.println(PO.getRecords().size()+
				";"+PO.getRowCount()+
				";"+PO.getPageCount());
	}
}
