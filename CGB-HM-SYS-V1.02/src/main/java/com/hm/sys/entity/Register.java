package com.hm.sys.entity;

import java.util.Date;

public class Register {
    private Integer id;

    private String reservepeople;

    private String reservephone;

    private String guestname;

    private String idcard;

    private String roomtype;

    private Integer roomnum;

    private Date intime;

    private Date outtime;

    private String roomstate;

    private Date createtime;

    private Integer earnest;

    private Integer liveday;

    private Integer livemoney;

    private String employee;

    private Integer reserve;

    private String guestname2;

    private String idcard2;

    private String guestname3;

    private String idcard3;

    private String guestname4;

    private String idcard4;

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
        this.reservepeople = reservepeople == null ? null : reservepeople.trim();
    }

    public String getReservephone() {
        return reservephone;
    }

    public void setReservephone(String reservephone) {
        this.reservephone = reservephone == null ? null : reservephone.trim();
    }

    public String getGuestname() {
        return guestname;
    }

    public void setGuestname(String guestname) {
        this.guestname = guestname == null ? null : guestname.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype == null ? null : roomtype.trim();
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

    public String getRoomstate() {
        return roomstate;
    }

    public void setRoomstate(String roomstate) {
        this.roomstate = roomstate == null ? null : roomstate.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee == null ? null : employee.trim();
    }

    public Integer getReserve() {
        return reserve;
    }

    public void setReserve(Integer reserve) {
        this.reserve = reserve;
    }

    public String getGuestname2() {
        return guestname2;
    }

    public void setGuestname2(String guestname2) {
        this.guestname2 = guestname2 == null ? null : guestname2.trim();
    }

    public String getIdcard2() {
        return idcard2;
    }

    public void setIdcard2(String idcard2) {
        this.idcard2 = idcard2 == null ? null : idcard2.trim();
    }

    public String getGuestname3() {
        return guestname3;
    }

    public void setGuestname3(String guestname3) {
        this.guestname3 = guestname3 == null ? null : guestname3.trim();
    }

    public String getIdcard3() {
        return idcard3;
    }

    public void setIdcard3(String idcard3) {
        this.idcard3 = idcard3 == null ? null : idcard3.trim();
    }

    public String getGuestname4() {
        return guestname4;
    }

    public void setGuestname4(String guestname4) {
        this.guestname4 = guestname4 == null ? null : guestname4.trim();
    }

    public String getIdcard4() {
        return idcard4;
    }

    public void setIdcard4(String idcard4) {
        this.idcard4 = idcard4 == null ? null : idcard4.trim();
    }
}