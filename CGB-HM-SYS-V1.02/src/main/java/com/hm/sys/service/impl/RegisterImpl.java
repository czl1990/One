package com.hm.sys.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hm.common.exception.ServiceException;
import com.hm.common.util.PageUtils;
import com.hm.common.vo.PageObject;
import com.hm.sys.dao.RegisterDao;
import com.hm.sys.dao.RoomStateDao;
import com.hm.sys.dao.RoomTypeDao;
import com.hm.sys.entity.Register;
import com.hm.sys.service.RegisterService;
import com.hm.sys.vo.GuestResult;
import com.hm.sys.vo.RegisterResult;
import com.hm.sys.vo.ReserveResult;
@Service
public class RegisterImpl implements RegisterService{
	@Autowired
	RegisterDao registerDao;
	@Autowired
	RoomStateDao roomStateDao;
	@Autowired
	RoomTypeDao roomTypeDao;
	@Override
	public PageObject<ReserveResult> findReservePageObjects(String reservePeople, Integer pageCurrent) {
		if(pageCurrent<1)
			throw new IllegalArgumentException("输入的页码错误");
		int rowCount = registerDao.getRowCountByReservepeople(reservePeople);
		if(rowCount==0)
			throw new ServiceException("没有找到记录");
		int pageSize = 20;
		int startIndex = (pageCurrent-1)*pageSize;
		List<ReserveResult> records = registerDao.findReservePageObjects(reservePeople, startIndex, pageSize);
		PageObject<ReserveResult> page = PageUtils.newPageObject(rowCount, records, pageSize, pageCurrent);
		return page;
	}
	@Override
	public Integer doValidById(Integer id, Integer reserve, String employee) {
		System.out.println(reserve);
		if(id<1) 
			throw new IllegalArgumentException("订单号无效");
		if(reserve!=0&&reserve!=1&&reserve!=2)
			throw new IllegalArgumentException("订单状态代码无效");
		Integer rows = registerDao.validById(id, reserve, employee);
		if(rows==0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}
	/**
	 * 插入预订订单
	 */
	@Override
	public Integer doInsertReserve(ReserveResult reserveResult, Integer roomAmount) {
		if(reserveResult==null)
			throw new IllegalArgumentException("请先输入订单数据");
		if(reserveResult.getReservepeople()==null||StringUtils.isEmpty(reserveResult.getReservepeople()))
			throw new IllegalArgumentException("请输入预订人姓名");
		if(reserveResult.getReservephone()==null||StringUtils.isEmpty(reserveResult.getReservephone()))
			throw new IllegalArgumentException("请输入预订人电话");
		/*
		if(reserveResult.getRoomtype()==null||StringUtils.isEmpty(reserveResult.getRoomtype()))
			throw new IllegalArgumentException("请选择房间类型");
		if(reserveResult.getIntime()==null)
			throw new IllegalArgumentException("请输入入住时间");
		*/
		if(roomAmount==null||roomAmount<1)
			throw new IllegalArgumentException("请输入正确的房间数");
		
	/*	
		if(reserveResult.getIntime().compareTo(new Date())<0)
			throw new IllegalArgumentException("输入的入住时间早 于当前时间 ");
		if(reserveResult.getOuttime()==null)
			throw new IllegalArgumentException("请输入退房时间");
		if(reserveResult.getOuttime().compareTo(reserveResult.getIntime())<0)
			throw new IllegalArgumentException("退房时间早于入住 时间");
		*/
	/*	
		//查找可用的房间
		List<Integer> roomNums = roomStateDao.findAvailableRoomNumsByRoomType(reserveResult.getRoomtype());
		if(roomNums==null||roomNums.size()<roomAmount)
			throw new ServiceException("剩余房间数不足");
		System.out.println(roomNums);
		//查找已经预订的房间
		List<Integer> unavailableNums = registerDao.findUnavailableRoomNumsByTimeRange(reserveResult.getIntime(), reserveResult.getOuttime(), roomNums);
		if(roomAmount>roomNums.size()-unavailableNums.size())
			throw new ServiceException("剩余房间不足");
		System.out.println(unavailableNums);
		//获取可预订的房间
		roomNums.removeAll(unavailableNums);
		System.out.println(roomNums);
		*/
		List<Integer> roomNums = this.getReservableRoom(reserveResult.getRoomtype(), reserveResult.getIntime(), reserveResult.getOuttime());
		if(roomNums==null||roomAmount>roomNums.size())
			throw new ServiceException("剩余房间不足");
		//分配房间号
		roomNums = roomNums.subList(0, roomAmount);
		Integer price = roomTypeDao.getPriceByRoomType(reserveResult.getRoomtype());
		
		reserveResult.setLivemoney(price*reserveResult.getLiveday());
		//插入订单
		//registerDao.insertReserve(reserveResult);
		for (Integer roomNum : roomNums) {
			reserveResult.setRoomnum(roomNum);
			Integer rows = registerDao.insertReserve(reserveResult);
			if(rows==0)
				throw new ServiceException("创建订单失败");
			
		}
		//返回自增的id值
		return reserveResult.getId();
		
	}
	/**
	 * 获取剩余可预订房间数
	 */
	@Override
	public List<Integer> getReservableRoom(String roomType, Date inTime, Date outTime) {
		if(roomType==null||StringUtils.isEmpty(roomType)||roomType.equals("默认"))
			throw new IllegalArgumentException("请选择房间类型");
		if(inTime==null)
			throw new IllegalArgumentException("请输入入住时间");
		Date date = new Date();
		long time = System.currentTimeMillis()-12*3600*1000;
		date.setTime(time);
		if(inTime.compareTo(date)<0)
			throw new IllegalArgumentException("输入的入住时间早 于当前时间 ");
		if(outTime==null)
			throw new IllegalArgumentException("请输入退房时间");
		if(outTime.compareTo(inTime)<0)
			throw new IllegalArgumentException("退房时间早于入住 时间");
		
		//查找可用的房间
		List<Integer> roomNums = roomStateDao.findAvailableRoomNumsByRoomType(roomType);
		if(roomNums==null)
			return null;
		System.out.println(roomNums);
		//查找已经预订的房间
		List<Integer> unavailableNums = registerDao.findUnavailableRoomNumsByTimeRange(inTime, outTime, roomNums);
		
		System.out.println(unavailableNums);
		//获取可预订的房间
		roomNums.removeAll(unavailableNums);
		System.out.println(roomNums);
		return roomNums;
	}
	@Override
	public Integer doUpdateReserveToRegister(GuestResult guestResult) {
		if(guestResult.getId()==null||guestResult.getId()<1)
			throw new IllegalArgumentException("预订订单号无效");
		if(guestResult.getGuestname()==null||StringUtils.isEmpty(guestResult.getGuestname()))
			throw new IllegalArgumentException("请输入 第一位住户信息");
		Integer rows = registerDao.updateReserveToRegister(guestResult);
		roomStateDao.updateRoomState(guestResult.getId());
		if(rows==null||rows==0)
			throw new ServiceException("订单可能已经不存在");
		return rows;
	}
	
	@Override
	public PageObject<RegisterResult> findRegisterPageObjects(String reservePeople, Integer pageCurrent) {
		if(pageCurrent<1)
			throw new IllegalArgumentException("输入的页码错误");
		int rowCount = registerDao.getRegisterRowCountByReservepeople(reservePeople);
		if(rowCount==0)
			throw new ServiceException("没有找到记录");
		int pageSize = 20;
		int startIndex = (pageCurrent-1)*pageSize;
		List<RegisterResult> records = registerDao.findRegisterPageObjects(reservePeople, startIndex, pageSize);
		PageObject<RegisterResult> page = PageUtils.newPageObject(rowCount, records, pageSize, pageCurrent);
		return page;
	}
	
	/**
	 * 获取住户信息
	 * @param id
	 * @return
	 */
	@Override
	public GuestResult doFindGuestById(Integer id) {
		if(id==null||id<1)
			throw new IllegalArgumentException("单号错误");
		GuestResult guest = registerDao.findGuestById(id);
		if(guest==null)
			throw new ServiceException("找不到住户记录");
		return guest;
	}
	
}
