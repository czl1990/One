package com.hm.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hm.sys.entity.SysRoomtype;


public interface SysRoomtypeDao {

int getRowCount(@Param("roomtype") String roomtype);
	
	List<SysRoomtype> findPageObjects(
			@Param("roomtype")String roomtype,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
}
