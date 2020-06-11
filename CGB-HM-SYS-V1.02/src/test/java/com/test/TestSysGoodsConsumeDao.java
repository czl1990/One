package com.test;

import java.util.List;

import org.junit.Test;

import com.hm.sys.dao.SysGoodsconsumeDao;
import com.hm.sys.entity.SysGoodsconsume;


public class TestSysGoodsConsumeDao extends TestBase {

	@Test
	public void testGetRowCount(){
		SysGoodsconsumeDao dao = 
				ctx.getBean("sysGoodsConsumeDao", SysGoodsconsumeDao.class);
		int rowCount = 
				dao.getRowCount(0);
		System.out.println("rowCount="+rowCount);
	}

	@Test
	public void testFindPageObjects(){
		SysGoodsconsumeDao dao = 
				ctx.getBean("sysGoodsConsumeDao", SysGoodsconsumeDao.class);
		List<SysGoodsconsume> list= 
				dao.findPageObjects(0, 0, 20);
		for(SysGoodsconsume sr : list)
		System.out.println(sr);
	}
	
}
