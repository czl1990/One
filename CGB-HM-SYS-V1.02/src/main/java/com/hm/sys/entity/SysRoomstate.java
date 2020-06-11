package com.hm.sys.entity;

import java.io.Serializable;

public class SysRoomstate  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6011077093813841230L;

	private Integer id;

    private Integer floor;

    private Integer roomnum;

    private String roomtype;

    private String roomstate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(Integer roomnum) {
        this.roomnum = roomnum;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype == null ? null : roomtype.trim();
    }

    public String getRoomstate() {
        return roomstate;
    }

    public void setRoomstate(String roomstate) {
        this.roomstate = roomstate == null ? null : roomstate.trim();
    }

	@Override
	public String toString() {
		return "SysRoomstate [id=" + id + ", floor=" + floor + ", roomnum=" + roomnum + ", roomtype=" + roomtype
				+ ", roomstate=" + roomstate + "]";
	}
    
}