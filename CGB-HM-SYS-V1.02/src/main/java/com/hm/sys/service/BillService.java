package com.hm.sys.service;

import com.hm.sys.entity.CollectBill;

public interface BillService {

	/**
	 * 把消费详细信息存到数据库
	 * @param bill
	 * @return
	 */
	int saveObject(CollectBill allBill);
}
