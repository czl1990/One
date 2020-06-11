package com.hm.sys.entity;

import java.io.Serializable;
import java.sql.Date;

public class SysBill implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7642511622456646101L;

	private Integer id;

    private String serialnumber;

    private Integer roomnum;

    private String guestname;

    private Integer needmoney;

    private Integer realmoney;

    private Integer refund;

    private String employee;

    private Date create;

    private Date checkin;

    private Date checkout;

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
        this.serialnumber = serialnumber == null ? null : serialnumber.trim();
    }

    public Integer getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(Integer roomnum) {
        this.roomnum = roomnum;
    }

    public String getGuestname() {
        return guestname;
    }

    public void setGuestname(String guestname) {
        this.guestname = guestname == null ? null : guestname.trim();
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
        this.employee = employee == null ? null : employee.trim();
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
		return "SysBill [id=" + id + ", serialnumber=" + serialnumber + ", roomnum=" + roomnum + ", guestname="
				+ guestname + ", needmoney=" + needmoney + ", realmoney=" + realmoney + ", refund=" + refund
				+ ", employee=" + employee + ", create=" + create + ", checkin=" + checkin + ", checkout=" + checkout
				+ "]";
	}
    
    
}