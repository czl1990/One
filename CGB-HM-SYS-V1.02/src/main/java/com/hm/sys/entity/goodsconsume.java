package com.hm.sys.entity;
/**
 * 获取房内消费的消费商品,数量,总消费额,消费时间
 */
import java.io.Serializable;
import java.util.Date;

public class goodsconsume implements Serializable{
	private static final long serialVersionUID = -401780890103313892L;
	private String goods;   //消费商品
	private Integer number;  //数量
	private Integer goodsmoney;//消费总金额
	private Date createtime;//消费时间
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
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "goodsconsume [goods=" + goods + ", number=" + number + ", goodsmoney=" + goodsmoney + ", createtime="
				+ createtime + "]";
	}
}
