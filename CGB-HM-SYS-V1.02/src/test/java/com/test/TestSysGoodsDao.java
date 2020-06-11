package com.test;

import java.util.List;

import org.junit.Test;

import com.hm.sys.dao.SysGoodsDao;
import com.hm.sys.entity.SysGoods;


public class TestSysGoodsDao extends TestBase {

	@Test
	public void testGetRowCount(){
		SysGoodsDao dao = 
				ctx.getBean("sysGoodsDao", SysGoodsDao.class);
		int rowCount = 
				dao.getRowCount("");
		System.out.println("rowCount="+rowCount);
	}

	@Test
	public void testFindPageObjects(){
		SysGoodsDao dao = 
				ctx.getBean("sysGoodsDao", SysGoodsDao.class);
		List<SysGoods> list= 
				dao.findPageObjects("", 0, 20);
		for(SysGoods sr : list)
		System.out.println(sr);
	}
	
}
