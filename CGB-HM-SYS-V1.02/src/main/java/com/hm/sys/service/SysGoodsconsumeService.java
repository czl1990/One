package com.hm.sys.service;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysGoodsconsume;

public interface SysGoodsconsumeService {

	PageObject<SysGoodsconsume> findPageObjects(
			Integer room,
			Integer pageCurrent);
}
