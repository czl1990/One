package com.hm.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hm.sys.entity.SysBills;
import com.hm.sys.entity.SysConsumer;


public interface SysConsumerDao {

	int getRowCount(@Param("goods") String goods);
	
	List<SysConsumer> findPageObjects(
			@Param("goods")String name,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	  int insertBills(SysBills bills);
	  
	  int insertObject(SysConsumer entity);
	  
	  int deleteObjects(@Param("ids")Integer... ids);
}
