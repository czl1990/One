package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.sys.entity.CollectBill;
import com.hm.sys.service.BillService;

@Controller
@RequestMapping("/bill/")
public class BillController整合 {

	@Autowired
	private BillService billService;
	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(CollectBill allBill){
		String Q="";
		System.out.println("测试");
		System.out.println("allBill="+allBill);
		billService.saveObject(allBill);
		String BBB="";
		return new JsonResult("收银成功");
	}
}
 
