package com.hm.sys.service;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysBill;

public interface SysBillService {

	PageObject<SysBill> findPageObjects(
			Integer room,
			Integer pageCurrent);
}
