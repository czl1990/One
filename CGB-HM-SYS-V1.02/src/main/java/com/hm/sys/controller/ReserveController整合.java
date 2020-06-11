package com.hm.sys.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.common.vo.PageObject;
import com.hm.sys.dao.RegisterDao;
import com.hm.sys.service.RegisterService;
import com.hm.sys.service.impl.RegisterImpl;
import com.hm.sys.vo.ReserveResult;
@Controller
@RequestMapping("/reserve/")
public class ReserveController整合 {
	@Autowired
	RegisterService registerService;
	
	@RequestMapping("doReserveListUI.do")
	public String doReserveListUI(){
		return "sys/reserve_list";
	}
	
	@RequestMapping("doReserveEditUI.do")
	public String doReserveEdit(){
		return "sys/reserve_edit";
	}
	/**
	 * 获取分页数据
	 * @param reservePeople
	 * @param pageCurrent
	 * @return
	 */
	@RequestMapping("doFindPageObjects.do")
	@ResponseBody
	public JsonResult doFindPageObjects(String reservePeople,Integer pageCurrent){
		PageObject<ReserveResult> result = registerService.findReservePageObjects(reservePeople, pageCurrent);
		return new JsonResult(result);
	}
	/**
	 * 更改预订状态
	 * @param id
	 * @param reserve
	 * @param employee
	 * @return
	 */
	@RequestMapping("doValidById.do")
	@ResponseBody
	public JsonResult doValidById(Integer id,Integer reserve,String employee){
		System.out.println(reserve);
		registerService.doValidById(id, reserve, employee);
		return new JsonResult("update ok");
	}
	@RequestMapping("doSaveObject.do")
	@ResponseBody
	public JsonResult doSaveObject(ReserveResult reserveResult , Integer roomAmount){
		System.out.println(reserveResult);
		
	//	registerService.doInsertReserve(reserveResult, roomAmount);
		return new JsonResult(registerService.doInsertReserve(reserveResult, roomAmount));
	}
	@RequestMapping("doGetReservableRoom.do")
	@ResponseBody
	public JsonResult doGetReservableRoom(String roomtype,Date intime,Date outtime){
		return new JsonResult(registerService.getReservableRoom(roomtype, intime, outtime));
	}
	
	
	
}
