package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.sys.service.CollectService;

@Controller
@RequestMapping("/collect/")
public class CollectController整合 {

	@Autowired
	private CollectService collectService;
	/**
	 * 基于房号查看该房间的总消费状态
	 * @param roomNum
	 * @return
	 */
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(Integer roomNum){
		return new JsonResult(
				collectService.findObjects(roomNum));
	}//http://localhost:8080/CGB-HM-SYS-V1.02/collect/doFindObjects.do?roomNum=204
}
