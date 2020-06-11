package com.hm.sys.service;


import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysConsumer;

public interface SysConsumerService {

	PageObject<SysConsumer> findPageObjects(
			String goods,
			Integer pageCurrent);
	 int insertBills(String json,Integer roomNum);
	 
	 int saveObject(SysConsumer entity);
	 
	 int deleteObjects(Integer...ids);
	 
}
