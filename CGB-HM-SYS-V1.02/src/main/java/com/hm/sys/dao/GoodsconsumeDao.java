package com.hm.sys.dao;

import java.util.List;

import com.hm.sys.entity.goodsconsume;

public interface GoodsconsumeDao {

	 /**
     * 基于房号获取房间的消费情况并存在goodsconsume对象中
     * @param roomNum
     * @return
     */
	List<goodsconsume> findgoodsconsume(Integer roomNum);
	
	/**
	 * 基于房号再点击结账后修改订单表的订单状态
	 * @param roomNum
	 * @return
	 */
	int updateConsumerState(Integer roomNum);
}
