package com.hm.sys.service;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysGoods;

public interface SysGoodsService {

	PageObject<SysGoods> findPageObjects(
			String goods,
			Integer pageCurrent);
}
