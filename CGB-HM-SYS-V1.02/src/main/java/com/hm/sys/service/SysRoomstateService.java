package com.hm.sys.service;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysRoomstate;

public interface SysRoomstateService {

	PageObject<SysRoomstate> findPageObjects(
			Integer room,
			Integer pageCurrent);
}
