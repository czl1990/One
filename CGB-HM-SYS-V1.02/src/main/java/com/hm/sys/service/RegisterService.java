package com.hm.sys.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.Register;
import com.hm.sys.vo.GuestResult;
import com.hm.sys.vo.RegisterResult;
import com.hm.sys.vo.ReserveResult;


public interface RegisterService {
	/**
	 * 预订订单当前页码的信息
	 * @param name 客户名
	 * @param pageCurrent 当前页
	 * @return
	 */
	PageObject<ReserveResult> findReservePageObjects(
			 String reservePeople,
			 Integer pageCurrent);
	/**
	 * 登记记录当前页码的信息
	 * @param name 客户名
	 * @param pageCurrent 当前页
	 * @return
	 */
	PageObject<RegisterResult> findRegisterPageObjects(
			String reservePeople,
			Integer pageCurrent);
	/**
	 * 改变订单状态
	 * @param id 订单id
	 * @param reserve 状态码 0：预订取消  1：入住订单 2：预订订单有效
	 * @param employee
	 * @return
	 */
	Integer doValidById(Integer id,Integer reserve,String employee);
	/**
	 * 插入预订订单数据
	 * @param reserveResult
	 * @return
	 */
	Integer doInsertReserve(ReserveResult reserveResult, Integer roomAmount);
	/**
	 * 获取可预订的房间
	 * @param roomType
	 * @param inTime
	 * @param outTime
	 * @return
	 */
	List<Integer> getReservableRoom(String roomType,Date inTime,Date outTime);
	/**
	 * 预订订单登记入住
	 * @param guestResult
	 * @return
	 */
	Integer doUpdateReserveToRegister(GuestResult guestResult);
	
	/**
	 * 获取住户信息
	 * @param id
	 * @return
	 */
	GuestResult doFindGuestById(Integer id);
	
}
