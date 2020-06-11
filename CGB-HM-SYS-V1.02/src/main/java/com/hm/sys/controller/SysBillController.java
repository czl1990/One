package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysBill;
import com.hm.sys.service.SysBillService;

@RequestMapping("/bill/")
@Controller
public class SysBillController {

	@Autowired
	private SysBillService sysBillService;
	
	@RequestMapping("doBillListUI")
	public String doBillListUI(){
		return "sys/bill_list";
	}
	
	@RequestMapping("doBill2ListUI")
	public String doBill2ListUI(){
		return "sys/bill2_list";
	}
	
	@RequestMapping("doBill3ListUI")
	public String doBill3ListUI(){
		return "sys/bill3_list";
	}
	
	@RequestMapping("doBill4ListUI")
	public String doBill4ListUI(){
		return "sys/bill4_list";
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(Integer room, 
			@RequestParam(value="pageCurrent"
			  ,required=false)Integer pageCurrent){
		PageObject<SysBill> pageObject =
				sysBillService.findPageObjects(room,pageCurrent);
		return new JsonResult(pageObject);
	}
}
