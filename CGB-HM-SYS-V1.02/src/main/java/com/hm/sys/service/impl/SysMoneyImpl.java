package com.hm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.common.exception.ServiceException;
import com.hm.common.vo.PageObject;
import com.hm.sys.dao.SysMoneyDao;
import com.hm.sys.entity.SysMoneyList;
import com.hm.sys.service.SysMoneyService;

@Service
public class SysMoneyImpl implements SysMoneyService{

	@Autowired
	private SysMoneyDao sysMoneyDao;

	@Override
	public PageObject<SysMoneyList> findPageObject(
			Integer roomNum, 
			Integer pageCurrent) {
		//1.验证参数的有效性
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("当前页码不正确");
		//2.基于用户名查询总记录数并进行相关判定
		int rowCount=sysMoneyDao.getRowCount(roomNum);
		if(rowCount==0)
			throw new ServiceException("系统没有查到对应记录");
		//3.基于用户名和当前页码名查询当前的语句
		int pageSize=10;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysMoneyList> records = sysMoneyDao.findPageObject(roomNum, startIndex, pageSize);
		//4.封装两次结果并返回
		PageObject<SysMoneyList> pageObject=new PageObject<>();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCount((rowCount-1)/pageSize+1);
		return pageObject;
	}

}
