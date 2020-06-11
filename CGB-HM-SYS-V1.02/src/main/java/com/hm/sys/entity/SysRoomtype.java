package com.hm.sys.entity;

import java.io.Serializable;

public class SysRoomtype implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6160256428757515954L;

	private Integer id;

    private String roomtype;

    private Integer price;

    private Integer stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype == null ? null : roomtype.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

	@Override
	public String toString() {
		return "SysRoomtype [id=" + id + ", roomtype=" + roomtype + ", price=" + price + ", stock=" + stock + "]";
	}
    
    
}