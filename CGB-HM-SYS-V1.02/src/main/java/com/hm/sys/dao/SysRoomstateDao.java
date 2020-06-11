package com.hm.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hm.sys.entity.SysRoomstate;


public interface SysRoomstateDao {

int getRowCount(@Param("roomNum") Integer roomNum);
	
	List<SysRoomstate> findPageObjects(
			@Param("roomNum")Integer roomNum,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
}
