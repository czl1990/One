package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hm.common.vo.JsonResult;
import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysBills;
import com.hm.sys.service.SysBillsService;

@Controller
@RequestMapping("/bills/")
public class SysBillsController整合 {
	@Autowired
	private SysBillsService sysBillsService;
	/**
	 * 返回日志页面
	 * @return
	 */
	@RequestMapping("doBillsListUI")
	public String doLogListUI(){
		return "sys/bills_list";
	}
	
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer...ids){
		sysBillsService.deleteObjects(ids);
		return new JsonResult("delete ok");
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(
			Integer roomNum,
			Integer pageCurrent){
		PageObject<SysBills> pageObject=
		sysBillsService.findPageObjects(roomNum, pageCurrent);
		return new JsonResult(pageObject);
	}
}