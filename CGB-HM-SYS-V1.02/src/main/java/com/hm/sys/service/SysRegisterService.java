package com.hm.sys.service;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysRegister;

public interface SysRegisterService {

	PageObject<SysRegister> findPageObjects(
			Integer room,
			Integer pageCurrent);
}
