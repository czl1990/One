package com.hm.sys.entity;
/**
 * 最总点击收账后存在数据库中的数据
 */
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Bill implements Serializable{
	private static final long serialVersionUID = 331195418976214831L;
	private Integer id;
	private String serialnumber;//流水号
	private Integer roomNum;//房号
	private String guestName;//客户名
	private Integer needmoney;//最终付款总额
	private Integer realmoney;//实际付款金额
	private Integer refund;//找回金额
	private String employee;//收银员工==登陆用户
	private Date create;//收银时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date checkin;//入店时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date checkout;//离店时间
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getNeedmoney() {
		return needmoney;
	}
	public void setNeedmoney(Integer needmoney) {
		this.needmoney = needmoney;
	}
	public Integer getRealmoney() {
		return realmoney;
	}
	public void setRealmoney(Integer realmoney) {
		this.realmoney = realmoney;
	}
	public Integer getRefund() {
		return refund;
	}
	public void setRefund(Integer refund) {
		this.refund = refund;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public Date getCreate() {
		return create;
	}
	public void setCreate(Date create) {
		this.create = create;
	}
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", serialnumber=" + serialnumber + ", roomNum=" + roomNum + ", guestName=" + guestName
				+ ", needmoney=" + needmoney + ", realmoney=" + realmoney + ", refund=" + refund + ", employee="
				+ employee + ", create=" + create + ", checkin=" + checkin + ", checkout=" + checkout + "]";
	}
}
