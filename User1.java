package com.icss.pojo;

public class User1 {
    private String sno;
    private String uname;
    private String upwd;
    private Integer urole;

    public User1() {
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public Integer getUrole() {
        return urole;
    }

    public void setUrole(Integer urole) {
        this.urole = urole;
    }

    @Override
    public String toString() {
        return "User1{" +
                "sno='" + sno + '\'' +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", urole=" + urole +
                '}';
    }
}
