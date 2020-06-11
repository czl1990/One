package com.hm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.common.exception.ServiceException;
import com.hm.common.vo.PageObject;
import com.hm.sys.dao.SysGoodsDao;
import com.hm.sys.entity.SysGoods;
import com.hm.sys.service.SysGoodsService;

@Service
public class SysGoodsServiceImpl implements SysGoodsService {

	@Autowired
	private SysGoodsDao sysGoodsDao ;
	
	@Override
	public PageObject<SysGoods> findPageObjects(String goods, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("当前页码不正确");
		//2.基于用户名查询总记录数并进行相关判定
		int rowCount=sysGoodsDao.getRowCount(goods);
		if(rowCount==0)
			throw new ServiceException("系统没查到对应记录");

		//3.基于用户名以及当前页码值查询当前记录
		int pageSize=10;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysGoods> records = 
				sysGoodsDao.findPageObjects(goods, startIndex, pageSize);
		//4.封装两次结果并返回
		PageObject<SysGoods> pageObject = new PageObject<>();

		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCount((rowCount-1)/pageSize+1);

		return pageObject;
	}

}
