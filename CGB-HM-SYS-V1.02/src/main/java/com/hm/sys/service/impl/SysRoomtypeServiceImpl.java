package com.hm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.common.exception.ServiceException;
import com.hm.common.vo.PageObject;
import com.hm.sys.dao.SysRoomtypeDao;
import com.hm.sys.entity.SysRoomtype;
import com.hm.sys.service.SysRoomtypeService;

@Service
public class SysRoomtypeServiceImpl implements SysRoomtypeService {

	@Autowired
	private SysRoomtypeDao sysRoomtypeDao ;
	
	@Override
	public PageObject<SysRoomtype> findPageObjects(String roomtype, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("当前页码不正确");
		//2.基于用户名查询总记录数并进行相关判定
		int rowCount=sysRoomtypeDao.getRowCount(roomtype);
		if(rowCount==0)
			throw new ServiceException("系统没查到对应记录");

		//3.基于用户名以及当前页码值查询当前记录
		int pageSize=10;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysRoomtype> records = 
				sysRoomtypeDao.findPageObjects(roomtype, startIndex, pageSize);
		//4.封装两次结果并返回
		PageObject<SysRoomtype> pageObject = new PageObject<>();

		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCount((rowCount-1)/pageSize+1);

		return pageObject;
	}

}
