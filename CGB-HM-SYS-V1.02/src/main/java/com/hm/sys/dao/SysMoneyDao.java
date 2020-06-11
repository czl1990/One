package com.hm.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysMoneyList;

/**
 * 收银系统
 * 数据层接口对象
 * @author UID
 *
 */
public interface SysMoneyDao {

	/**
	 * 查询已入住的房间数量
	 * @param roomId
	 * @return
	 */
	int getRowCount(@Param("roomNum")Integer roomNum);
	
	/**
	 * 查找房号、入住时间、退房时间客户的姓名手机号
	 * @return
	 */
	List<SysMoneyList> findPageObject(
			@Param("roomNum")Integer roomNum,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize
			);
	
}
