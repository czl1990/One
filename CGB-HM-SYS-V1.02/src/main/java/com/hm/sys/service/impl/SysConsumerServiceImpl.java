package com.hm.sys.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.hm.common.exception.ServiceException;
import com.hm.common.vo.PageObject;
import com.hm.sys.dao.SysConsumerDao;
import com.hm.sys.entity.SysBills;
import com.hm.sys.entity.SysConsumer;
import com.hm.sys.service.SysConsumerService;

@Service
public class SysConsumerServiceImpl implements SysConsumerService {

	@Autowired
	private SysConsumerDao sysConsumerDao;
	
	public PageObject<SysConsumer> findPageObjects(String goods, Integer pageCurrent) {
		//1.验证参数的有效性
				if(pageCurrent==null||pageCurrent<1)
				throw new IllegalArgumentException("当前页码不正确");
				//2.基于用户名查询总记录数并进行相关判定
				int rowCount=sysConsumerDao.getRowCount(goods);
				if(rowCount==0)
				throw new ServiceException("系统没查到对应记录");
				
				//3.基于用户名以及当前页码值查询当前记录
				int pageSize=100;
				int startIndex=(pageCurrent-1)*pageSize;
				List<SysConsumer> records = 
						sysConsumerDao.findPageObjects(goods, startIndex, pageSize);
				//4.封装两次结果并返回
				PageObject<SysConsumer> pageObject = new PageObject<>();
				
				pageObject.setPageCurrent(pageCurrent);
				pageObject.setPageSize(pageSize);
				pageObject.setRowCount(rowCount);
				pageObject.setRecords(records);
				pageObject.setPageCount((rowCount-1)/pageSize+1);
				
				return pageObject;
	}
	@Override
	@Transactional
	public int insertBills(String json,Integer roomNum) {
		//1.参数有效性验证
				List<SysBills> list = JSONArray.parseArray(json, SysBills.class);
				for (SysBills bills : list) {
					if(bills==null)
						throw new ServiceException("下单对象不能为空");
					if(bills.getNumber()==0)
						throw new ServiceException("数量不能为空");
					if(roomNum==null)
						throw new ServiceException("房号不能为空");
					//2.保存用户信息
					//2.4将用户信息写入到数据库
					bills.setRoomNum(roomNum);
					sysConsumerDao.insertBills(bills);
					//3.将用户和角色关系数据写入数据库
					//if(count>0)//为了掩饰事务
				}
				return roomNum;
	}
	
	@Override
	public int saveObject(SysConsumer entity) {
		//1.验证参数合法性
    	if(entity==null)
    	throw new IllegalArgumentException("保存对象不能为空");
    	if(StringUtils.isEmpty(entity.getGoods()))
    	throw new IllegalArgumentException("商品价格不能为空");
    	if(StringUtils.isEmpty(entity.getPrice()))
    		throw new IllegalArgumentException("商品价格不能为空");
    	//...
    	//2.保存菜单信息
    	int rows = -1;
    	try{
    	rows=sysConsumerDao.insertObject(entity);
    	}catch(Error e){//Error系统级错误
    	e.printStackTrace();//给运维人员发短信
    	}catch(RuntimeException e){
    	e.printStackTrace();////给运维人员发短信
    	throw new ServiceException("系统维护中..");
    	}
    	//3.返回结果
    	return rows;
    }
	@Override
	public int deleteObjects(Integer... ids) {
	   	//1.参数有效性验证
    	if(ids==null||ids.length==0)
    	throw new IllegalArgumentException("id值无效");
    	//2.执行删除操作
    	int rows=-1;
    	try{
    	 rows=sysConsumerDao.deleteObjects(ids);
    	}catch(Throwable e){
    	 //给运维人员发短信
    	 //写错误日志
    	 throw e;
    	}
    	//3.验证删除结果
    	if(rows==0)
    	throw new ServiceException("记录可能已经不存在");
    	//4.返回结果
    	return rows;
	}
}
