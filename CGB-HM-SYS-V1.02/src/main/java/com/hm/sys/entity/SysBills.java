package com.hm.sys.entity;

import java.io.Serializable;


public class SysBills implements Serializable{
	
	private static final long serialVersionUID = 6079909067518074365L;
	private Integer id;
	private String goods;
	private Integer number;
	private Integer goodsmoney;
	private Integer roomNum;
	private String createtime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getGoodsmoney() {
		return goodsmoney;
	}
	public void setGoodsmoney(Integer goodsmoney) {
		this.goodsmoney = goodsmoney;
	}
	public Integer getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "SysBills [id=" + id + ", goods=" + goods + ", number=" + number + ", goodsmoney=" + goodsmoney
				+ ", roomNum=" + roomNum + ", createtime=" + createtime + "]";
	}
	
	
	
}
