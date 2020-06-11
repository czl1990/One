package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.common.vo.PageObject;
import com.hm.sys.entity.Register;
import com.hm.sys.service.RegisterService;
import com.hm.sys.vo.GuestResult;
import com.hm.sys.vo.RegisterResult;
import com.hm.sys.vo.ReserveResult;
@RequestMapping("/register/")
@Controller
public class RegisterController整合 {
	@Autowired
	RegisterService registerService;
	@RequestMapping("doRegisterListUI.do")
	public String doRegisterListUI(){
		return "sys/register_list";
	}
	@RequestMapping("doRegisterEditUI.do")
	public String doRegisterEditUI(){
		return "sys/register_edit";
	}
	@RequestMapping("doFindObjectById.do")
	@ResponseBody
	public JsonResult doFindObjectById(){
		return new JsonResult();
	}
	/**
	 * 预订订单登记入住
	 * @param guestResult
	 * @return
	 */
	@RequestMapping("doUpdateReserveToRegister.do")
	@ResponseBody
	public JsonResult doUpdateReserveToRegister(GuestResult guestResult){
		System.out.println(guestResult.getGuestname());
		registerService.doUpdateReserveToRegister(guestResult);
		return new JsonResult("update ok");
	}
	
	/**
	 * 获取登记信息分页数据
	 * @param reservePeople
	 * @param pageCurrent
	 * @return
	 */
	@RequestMapping("doFindPageObjects.do")
	@ResponseBody
	public JsonResult doFindPageObjects(String reservePeople,Integer pageCurrent){
		PageObject<RegisterResult> result = registerService.findRegisterPageObjects(reservePeople, pageCurrent);
		return new JsonResult(result);
	}
	
	/**
	 * 根据登记表id找住户信息
	 * @param id
	 * @return
	 */
	@RequestMapping("doFindGuestById.do")
	@ResponseBody
	public JsonResult doFindGuestById(Integer id){
		return new JsonResult(registerService.doFindGuestById(id));
	}
	
	
	
}
