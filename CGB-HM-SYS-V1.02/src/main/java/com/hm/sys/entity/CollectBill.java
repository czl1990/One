package com.hm.sys.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CollectBill implements Serializable{
	private static final long serialVersionUID = -1242377033438591373L;
	private String serialnumber;   //流水号
	private Integer needmoney;    //房间总消费(房费+房内消费-定金)
	private Integer roomNum;//房间号
	private String employee;//收银员工姓名(直接用登陆系统的员工)
	private String guestName;//客户姓名
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date intime;//入店时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date outtime;//离店时间
	private Integer livemoney;//房间总租金
	private Integer earnest;//定金
	private List<goodsconsume> goodsconsume;  //房间内消费记录
	
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public Integer getNeedmoney() {
		return needmoney;
	}
	public void setNeedmoney(Integer needmoney) {
		this.needmoney = needmoney;
	}
	public String getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
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
	public Integer getLivemoney() {
		return livemoney;
	}
	public void setLivemoney(Integer livemoney) {
		this.livemoney = livemoney;
	}
	public Integer getEarnest() {
		return earnest;
	}
	public void setEarnest(Integer earnest) {
		this.earnest = earnest;
	}
	public List<goodsconsume> getGoodsconsume() {
		return goodsconsume;
	}
	public void setGoodsconsume(List<goodsconsume> goodsconsume) {
		this.goodsconsume = goodsconsume;
	}
	@Override
	public String toString() {
		final int maxLen = 10;
		return "AllBill [serialnumber=" + serialnumber + ", needmoney=" + needmoney + ", roomNum=" + roomNum
				+ ", employee=" + employee + ", guestName=" + guestName + ", intime=" + intime + ", outtime=" + outtime
				+ ", livemoney=" + livemoney + ", earnest=" + earnest + ", goodsconsume="
				+ (goodsconsume != null ? goodsconsume.subList(0, Math.min(goodsconsume.size(), maxLen)) : null) + "]";
	}
}
