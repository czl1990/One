package com.hm.sys.service;


import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysBills;

public interface SysBillsService {
	 /**
	  * 基于id删除日志记录
	  * @param ids
	  * @return
	  */
	 int deleteObjects(Integer...ids);
	 
	 /**
	  * 基于查询条件分页查询当前日志行为数据
	  * @param username 页面输入的用户名
	  * @param pageCurrent 当前页码值
	  * @return
	  */
	 PageObject<SysBills> findPageObjects(
			 Integer roomNum,
			 Integer pageCurrent);
	 
	
}
