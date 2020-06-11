package com.hm.sys.entity;

import java.io.Serializable;
import java.sql.Date;

public class SysGoodsconsume implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5809326660452569655L;

	private Integer id;

    private Integer roomnum;

    private String goods;

    private Integer number;

    private Date createtime;

    private Integer goodsmoney;

    private String employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(Integer roomnum) {
        this.roomnum = roomnum;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods == null ? null : goods.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getGoodsmoney() {
        return goodsmoney;
    }

    public void setGoodsmoney(Integer goodsmoney) {
        this.goodsmoney = goodsmoney;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee == null ? null : employee.trim();
    }

	@Override
	public String toString() {
		return "SysGoodsconsume [id=" + id + ", roomnum=" + roomnum + ", goods=" + goods + ", number=" + number
				+ ", createtime=" + createtime + ", goodsmoney=" + goodsmoney + ", employee=" + employee + "]";
	}
    
    
}