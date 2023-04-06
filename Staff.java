package com.icss.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Staff {
    private String sno;
    private String sname;
    private Date sbirthday;
    private String saddress;
    private String stel;

    // 一个员工对象 有多条打卡记录 关联关系
    private List<Card> cardList;
// 一个员工对应一个用户信息
    private User1 user1;

    public User1 getUser1() {
        return user1;
    }

    public void setUser1(User1 user1) {
        this.user1 = user1;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public Staff() {
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getSbirthday() {
        return sbirthday;
    }

    public void setSbirthday(Date sbirthday) {
        this.sbirthday = sbirthday;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sbirthday=" + sbirthday +
                ", saddress='" + saddress + '\'' +
                ", stel='" + stel + '\'' +
                '}';
    }
}
