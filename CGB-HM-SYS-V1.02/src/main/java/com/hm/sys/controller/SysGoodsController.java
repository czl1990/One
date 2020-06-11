package com.hm.sys.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hm.common.vo.JsonResult;
import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysConsumer;
import com.hm.sys.service.SysConsumerService;

@RequestMapping("/goods/")
@Controller
public class SysGoodsController {


	@Autowired
	private SysConsumerService sysConsumerService;
	
	@RequestMapping("doGoodsListUI")
	public String doGoodsListUI() {
		return "sys/goods_list";
	}

	@RequestMapping("doGoods2ListUI")
	public String doGoods2ListUI() {
		return "sys/goods2_list";
	}
	
	@RequestMapping("doConsumerListUI")
	public String doConsumerListUI(){
		return "sys/consumer_list";
	}

	@RequestMapping("doConsumerEditUI")
	public String doConsumerEditUI(){
		return "sys/consumer_edit";
	}	
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username, 
			@RequestParam(value="pageCurrent"
			  ,required=false)Integer pageCurrent){
		/*Cannot make a static reference to the non-static method 
		 * findPageObjects(String, Integer) from the type SysLogService*/
		PageObject<SysConsumer> pageObject =
				sysConsumerService.findPageObjects(username,pageCurrent);
		return new JsonResult(pageObject);
	}
	@RequestMapping("doConsumerSaveData")
	@ResponseBody
	  public JsonResult doSaveObject(
			  @RequestParam(name="json") String json,@RequestParam(name="roomId") Integer roomNum) throws JsonParseException, JsonMappingException, IOException{
		sysConsumerService.insertBills(json, roomNum);
		  return new JsonResult("save ok");
	  }
	
	@PostMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysConsumer entity){
		sysConsumerService.saveObject(entity);
		return new JsonResult("save ok");
	}

	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer...ids){
		sysConsumerService.deleteObjects(ids);
		return new JsonResult("delete ok");
	}

}
