package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysRoomtype;
import com.hm.sys.service.SysRoomtypeService;

@RequestMapping("/roomtype/")
@Controller
public class SysRoomtypeController {

	@Autowired 
	private SysRoomtypeService sysRoomtypeService;


	@RequestMapping("doRoomtypeListUI")
	public String doRoomtypeListUI() {
		return "sys/roomtype_list";
	}
	
	@RequestMapping("doRoomtype2ListUI")
	public String doRoomtype2ListUI() {
		return "sys/roomtype2_list";
	}

	@RequestMapping("doFindPageObjects")
	@ResponseBody 
	public JsonResult doFindPageObjects(String roomtype,
			@RequestParam(value="pageCurrent"
			,required=false)Integer pageCurrent){
		PageObject<SysRoomtype> pageObject =
				sysRoomtypeService.findPageObjects(roomtype,pageCurrent); 
		return new JsonResult(pageObject);
	}
}
