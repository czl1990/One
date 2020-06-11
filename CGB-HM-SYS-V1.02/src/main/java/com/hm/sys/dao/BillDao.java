package com.hm.sys.dao;

import com.hm.sys.entity.Bill;

public interface BillDao {

	/**
	 * 查询总总账单表的最大流水号
	 * @return
	 */
	String findSerialnumber();
	/**
	 * 把总消费信息存到数据库
	 * @param bill
	 * @return
	 */
	int insertObject(Bill bill);
	
}
