package test;

import java.util.List;
import java.util.Map;

public interface RegisterDao {

	/**
	 * 在收银页面点击查看,基于房号查询guestName,roomNum,intime,outtime,
		livemoney,earnest这些信息并存在map集合中
	 * @param roomNum
	 * @return
	 */
	List<Map<Object,Object>> findRegisterObjects(Integer roomNum);
	/**
	 * 基于房号再点击结账后修改登记表房间状态
	 * @param roomNum
	 * @return
	 */
	int updateRoomState(Integer roomNum);
}
