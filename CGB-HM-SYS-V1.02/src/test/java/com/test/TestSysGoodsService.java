package com.test;

import org.junit.Test;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysGoods;
import com.hm.sys.service.SysGoodsService;


public class TestSysGoodsService extends TestBase{

	@Test
	public void testFindPageObjects(){
		SysGoodsService ServiceImpl
		= ctx.getBean("sysGoodsServiceImpl",SysGoodsService.class);
		PageObject<SysGoods> PO = ServiceImpl.findPageObjects("", 1);
		System.out.println(PO.getRecords().size()+
				";"+PO.getRowCount()+
				";"+PO.getPageCount());
	}
}
