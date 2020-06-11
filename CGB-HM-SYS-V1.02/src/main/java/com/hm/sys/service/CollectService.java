package com.hm.sys.service;

import com.hm.sys.entity.CollectBill;

public interface CollectService {

	/**
	 * 基于房号获取该房号的房费和房内消费...并存在AllBill对象中
	 * @param roomNum
	 * @return
	 */
	CollectBill findObjects(Integer roomNum);
}
