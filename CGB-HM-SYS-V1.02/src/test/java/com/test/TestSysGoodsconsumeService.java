package com.test;

import org.junit.Test;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysGoodsconsume;
import com.hm.sys.service.SysGoodsconsumeService;


public class TestSysGoodsconsumeService extends TestBase{

	@Test
	public void testFindPageObjects(){
		SysGoodsconsumeService ServiceImpl
		= ctx.getBean("sysGoodsconsumeServiceImpl",SysGoodsconsumeService.class);
		PageObject<SysGoodsconsume> PO = ServiceImpl.findPageObjects(0, 1);
		System.out.println(PO.getRecords().size()+
				";"+PO.getRowCount()+
				";"+PO.getPageCount());
	}
}
