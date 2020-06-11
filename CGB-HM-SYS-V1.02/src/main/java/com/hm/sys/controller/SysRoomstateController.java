package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysRoomstate;
import com.hm.sys.service.SysRoomstateService;

@RequestMapping("/roomstate/")
@Controller
public class SysRoomstateController {

	@Autowired 
	private SysRoomstateService sysRoomstateService;


	@RequestMapping("doRoomstateListUI")
	public String doRoomstateListUI() {
		return "sys/roomstate_list";
	}
	
	@RequestMapping("doRoomstate2ListUI")
	public String doRoomstate2ListUI() {
		return "sys/roomstate2_list";
	}

	@RequestMapping("doFindPageObjects")
	@ResponseBody 
	public JsonResult doFindPageObjects(Integer room,
			@RequestParam(value="pageCurrent" 
			,required=false)Integer pageCurrent){
		PageObject<SysRoomstate> pageObject =
				sysRoomstateService.findPageObjects(room,pageCurrent); 
		return new JsonResult(pageObject); }
}
