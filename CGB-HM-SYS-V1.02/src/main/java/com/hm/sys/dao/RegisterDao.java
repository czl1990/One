package com.hm.sys.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hm.sys.entity.Register;
import com.hm.sys.vo.GuestResult;
import com.hm.sys.vo.RegisterResult;
import com.hm.sys.vo.ReserveResult;

public interface RegisterDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);
    /**
     * 
     * @param customerIds
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<ReserveResult> findReservePageObjects(
			 @Param("reservepeople")String reservepeople, 
			 @Param("startIndex")Integer startIndex,
			 @Param("pageSize")Integer pageSize);
    Integer getRowCountByReservepeople(@Param("reservepeople")String reservepeople);
    /**
     * 用于修改订单状态，0表示预订订单取消，2表示预订订单有效，1表示入住订单
     * @param id
     * @param reserve
     * @param employee
     * @return
     */
    Integer validById(@Param("id")Integer id,
			@Param("reserve")Integer reserve,
			@Param("employee")String employee);
    /**
     * 获取登记页面数据
     * @param reservepeople
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<RegisterResult> findRegisterPageObjects(
			 @Param("reservepeople")String reservepeople, 
			 @Param("startIndex")Integer startIndex,
			 @Param("pageSize")Integer pageSize);
    /**
     * 获取登记记录的行数
     * @param reservepeople
     * @return
     */
    Integer getRegisterRowCountByReservepeople(@Param("reservepeople")String reservepeople);
    
    /**
     * 插入预订信息
     * @param reserveResult
     * @return
     */
    Integer insertReserve(ReserveResult reserveResult);
   /**
    * 查找不可预订的房间号
    * @param inTime
    * @param outTime
    * @param roomNum
    * @return
    */
    List<Integer> findUnavailableRoomNumsByTimeRange(
    		@Param("inTime")Date inTime,
    		@Param("outTime")Date outTime,
    		@Param("roomNums")List<Integer> roomNums);
    /**
     * 预订 订单入住登记
     * @param guestResult
     * @return
     */
    Integer updateReserveToRegister(GuestResult guestResult);
    
    /**
     * 根据订单id查找住户信息
     * @param id 记录id
     * @return
     */
    GuestResult findGuestById(Integer id);
    
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