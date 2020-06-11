package com.hm.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hm.sys.entity.SysGoodsconsume;


public interface SysGoodsconsumeDao {

int getRowCount(@Param("roomNum") Integer roomNum);
	
	List<SysGoodsconsume> findPageObjects(
			@Param("roomNum")Integer roomNum,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
}
