package test;

public interface RoomstateDao {
	
	/**
	 * 基于房号再点击结账后修改客房表房间状态
	 * @param roomNum
	 * @return
	 */
	int updateRoomState(Integer roomNum);
}
