package com.hm.sys.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SysMoneyList implements Serializable{
	
	private static final long serialVersionUID = 3616993581179397451L;
	
	/*已入住房间序号*/
	private Integer id;
	/*房间号*/
	private Integer roomNum;
	/*注册登记的客户姓名*/
	private String guestName;
	/*房间类型*/
	private String roomType;
	/*入住时间*/
	private Date    intime;
	/*退房时间*/
	private Date    outtime;
	
	public SimpleDateFormat sdf;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Date getIntime() {
		return intime;
	}
	public void setIntime(Date intime) {
		this.intime = intime;
	}
	public Date getOuttime() {
		return outtime;
	}
	public void setOuttime(Date outtime) {
		this.outtime = outtime;
	}
	@Override
	public String toString() {
		return "SysMoneyList [id=" + id + ", roomNum=" + roomNum + ", guestName=" + guestName + ", roomType=" + roomType
				+ ", intime=" + intime + ", outtime=" + outtime + "]";
	}
	
}
