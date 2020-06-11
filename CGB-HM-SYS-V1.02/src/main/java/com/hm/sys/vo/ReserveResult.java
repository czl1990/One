package com.hm.sys.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hm.common.util.DateJsonDeserialize;

/**
 * 存放预订信息的对象
 * @author UID
 *
 */
public class ReserveResult implements Serializable{

	private static final long serialVersionUID = 9048918886214656291L;

	private Integer id;//预订订单号

	private String reservepeople;//订房人

	private String reservephone;//订房人电话
	
	private String roomtype;//房间类型

    private Integer roomnum;//房间号
 //   @JsonDeserialize(using = DateJsonDeserialize.class)
    private Date intime;//入住时间

//    @JsonDeserialize(using = DateJsonDeserialize.class)
    private Date outtime;//退房时间
    
    private Date createtime;//创建时间
    
    private Integer reserve=2;//预订订单状态
    
    private String employee;//员工姓名
    
    private Integer earnest=100;//押金

    private Integer liveday;//天数

    private Integer livemoney;//房费

    

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

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

	public Integer getReserve() {
		return reserve;
	}

	public void setReserve(Integer reserve) {
		this.reserve = reserve;
	}

	@Override
	public String toString() {
		return "ReserveResult [id=" + id + ", reservepeople=" + reservepeople + ", reservephone=" + reservephone
				+ ", roomtype=" + roomtype + ", roomnum=" + roomnum + ", intime=" + intime + ", outtime=" + outtime
				+ ", createtime=" + createtime + ", reserve=" + reserve + ", employee=" + employee + "]";
	}

	public Integer getEarnest() {
		return earnest;
	}

	public void setEarnest(Integer earnest) {
		this.earnest = earnest;
	}

	public Integer getLiveday() {
		return liveday;
	}

	public void setLiveday(Integer liveday) {
		this.liveday = liveday;
	}

	public Integer getLivemoney() {
		return livemoney;
	}

	public void setLivemoney(Integer livemoney) {
		this.livemoney = livemoney;
	}
}
