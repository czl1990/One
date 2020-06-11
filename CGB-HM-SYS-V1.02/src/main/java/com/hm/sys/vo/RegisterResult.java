package com.hm.sys.vo;

import java.io.Serializable;
import java.util.Date;
/**
 * 登记页面信息
 * @author UID
 *
 */
public class RegisterResult implements Serializable{

	private static final long serialVersionUID = 6459120348564374002L;

	private Integer id;//预订订单号

	private String reservepeople;//订房人

	private String reservephone;//订房人电话
	
	private String roomtype;//房间类型

    private Integer roomnum;//房间号
    
    private String guestname;

    private String guestname2;

    private String guestname3;

    private String guestname4;
    
    private Integer earnest;
    
    private Integer livemoney;

    private Date intime;//入住时间

    private Date outtime;//退房时间

    private Date createtime;//创建时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReservepeople() {
		return reservepeople;
	}

	public void setReservepeople(String reservepeople) {
		this.reservepeople = reservepeople;
	}

	public String getReservephone() {
		return reservephone;
	}

	public void setReservephone(String reservephone) {
		this.reservephone = reservephone;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
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
		this.guestname = guestname;
	}

	public String getGuestname2() {
		return guestname2;
	}

	public void setGuestname2(String guestname2) {
		this.guestname2 = guestname2;
	}

	public String getGuestname3() {
		return guestname3;
	}

	public void setGuestname3(String guestname3) {
		this.guestname3 = guestname3;
	}

	public String getGuestname4() {
		return guestname4;
	}

	public void setGuestname4(String guestname4) {
		this.guestname4 = guestname4;
	}

	public Integer getEarnest() {
		return earnest;
	}

	public void setEarnest(Integer earnest) {
		this.earnest = earnest;
	}

	public Integer getLivemoney() {
		return livemoney;
	}

	public void setLivemoney(Integer livemoney) {
		this.livemoney = livemoney;
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

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}
