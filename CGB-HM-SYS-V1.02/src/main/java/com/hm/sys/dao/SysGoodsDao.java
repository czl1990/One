package com.hm.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hm.sys.entity.SysGoods;


public interface SysGoodsDao {

int getRowCount(@Param("goods") String goods);
	
	List<SysGoods> findPageObjects(
			@Param("goods")String goods,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
}
