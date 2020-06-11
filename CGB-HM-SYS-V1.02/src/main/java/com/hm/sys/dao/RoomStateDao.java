package com.hm.sys.dao;

import java.util.List;

public interface RoomStateDao {
	/**
	 * 通过房间类型查找可用的房间
	 * @param roomType
	 * @return
	 */
	List<Integer> findAvailableRoomNumsByRoomType(String roomType);
	Integer updateRoomState(Integer id);
	
	/**
	 * 基于房号再点击结账后修改客房表房间状态
	 * @param roomNum
	 * @return
	 */
	int updateRoomtype(Integer roomNum);
}
