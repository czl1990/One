package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysRegister;
import com.hm.sys.service.RegisterService;
import com.hm.sys.service.SysRegisterService;
import com.hm.sys.vo.GuestResult;
import com.hm.sys.vo.RegisterResult;

@RequestMapping("/register2/")
@Controller
public class SysRegisterController {

	@Autowired 
	private SysRegisterService sysRegisterService;

	@RequestMapping("doRegister5ListUI")
	public String doRegister5ListUI() {
		return "sys/register5_list";
	}

	@RequestMapping("doRegisterListUI")
	public String doRegisterListUI() {
		return "sys/register2_list";
	}
	
	@RequestMapping("doRegister2ListUI")
	public String doRegister2ListUI() {
		return "sys/register2_list";
	}

	@RequestMapping("doRegister3ListUI")
	public String doRegister3ListUI() {
		return "sys/register2_edit";
	}

	@RequestMapping("doFindPageObjects")
	@ResponseBody 
	public JsonResult doFindPageObjects(Integer room,
			@RequestParam(value="pageCurrent" 
			,required=false)Integer pageCurrent){
		PageObject<SysRegister> pageObject =
				sysRegisterService.findPageObjects(room,pageCurrent); 
		return new JsonResult(pageObject); }

}
