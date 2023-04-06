package com.icss.pojo;

import java.util.Date;

public class Card {
    private Integer cid;
    private Date ctime;
    private String ctatus;
    private String sno;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
//    private Staff staff;

    public Card() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getCtatus() {
        return ctatus;
    }

    public void setCtatus(String ctatus) {
        this.ctatus = ctatus;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cid=" + cid +
                ", ctime=" + ctime +
                ", ctatus='" + ctatus + '\'' +
                ", sno='" + sno + '\'' +
                '}';
    }
}
