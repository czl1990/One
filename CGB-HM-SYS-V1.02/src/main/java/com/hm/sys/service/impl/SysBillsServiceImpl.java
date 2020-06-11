package com.hm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.hm.common.exception.ServiceException;
import com.hm.common.vo.PageObject;
import com.hm.sys.dao.SysBillsDao;
import com.hm.sys.entity.SysBills;
import com.hm.sys.service.SysBillsService;


@Service
public class SysBillsServiceImpl implements SysBillsService{
	@Autowired //DI(Spring采用DI方式自动为属性赋值)
	@Qualifier("sysBillsDao")//可以基于此注解指定注入哪个对象
    private SysBillsDao sysBillsDao;
    
    @Override
    public int deleteObjects(Integer... ids) {
    	//1.参数有效性验证
    	if(ids==null||ids.length==0)
    	throw new IllegalArgumentException("id值无效");
    	//2.执行删除操作
    	int rows=-1;
    	try{
    	 rows=sysBillsDao.deleteObjects(ids);
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
    
	@Override
	public PageObject<SysBills> findPageObjects(
			Integer roomNum, Integer pageCurrent) {
	    //1.验证参数的有效性
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("页码值不正确");
		//2.基于用户名查询总记录数并进行相关判定
		int rowCount=sysBillsDao.getRowCount(roomNum);
		if(rowCount==0)
		throw new ServiceException("没有找到对应记录");
		//3.基于用户名以及当前页码值查询当前的记录
		int pageSize=20;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysBills> records=
		sysBillsDao.findPageObjects(roomNum, startIndex, pageSize);
		//4.封装两次结果并返回.
		PageObject<SysBills> po=new PageObject<>();
		po.setRowCount(rowCount);
		po.setRecords(records);
		po.setPageSize(pageSize);
		po.setPageCurrent(pageCurrent);
		/*int pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0){
			pageCount++;
		}*/
		po.setPageCount((rowCount-1)/pageSize+1);
		return po;
	}
}
