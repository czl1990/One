package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysMoneyList;
import com.hm.sys.service.SysMoneyService;

@RequestMapping("/money/")
@Controller
public class SysMoneyController整合 {
	
	@Autowired
	private SysMoneyService sysMoneyService; 

	@RequestMapping("doMoneyListUI")
	public String doMoneyListUI(){
		return "sys/money_list";
	}
	
	@RequestMapping("dofindPageObject")
	@ResponseBody
	public JsonResult dofindPageObject(Integer roomNum,Integer pageCurrent){
		PageObject<SysMoneyList> page = sysMoneyService.findPageObject(roomNum, pageCurrent);
		System.out.println(page);
		return new JsonResult(page);
	}
	
	/**查看页面跳转*/
	@RequestMapping("doBillIndex")
	public String doBillIndex(){
		return "bill";
	}
}
