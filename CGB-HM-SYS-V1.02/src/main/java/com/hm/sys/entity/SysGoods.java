package com.hm.sys.entity;

import java.io.Serializable;

public class SysGoods implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1792675882356899305L;

	private Integer id;

    private String goods;

    private Integer price;

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
        this.goods = goods == null ? null : goods.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

	@Override
	public String toString() {
		return "Goods [id=" + id + ", goods=" + goods + ", price=" + price + "]";
	}
    
    
}