package com.hm.sys.service;

import org.apache.ibatis.annotations.Param;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysMoneyList;

public interface SysMoneyService {

	/**
	 * 分页查询，显示上一页，下一页，总页数，总记录数
	 * pageCurrent 当前的页码值
	 * @return
	 */
	PageObject<SysMoneyList> findPageObject(
			@Param("roomNum")Integer roomNum,
			@Param("pageCurrent")Integer pageCurrent);
}
