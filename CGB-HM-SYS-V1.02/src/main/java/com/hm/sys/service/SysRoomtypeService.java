package com.hm.sys.service;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysRoomtype;

public interface SysRoomtypeService {

	PageObject<SysRoomtype> findPageObjects(
			String roomtype,
			Integer pageCurrent);
}
