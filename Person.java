package com.icss.pojo;

public class Person {
    private Integer personId;
    private String  personName;
    private String personPwd;

    public Person() {
    }

    public Person(Integer personId, String personName, String personPwd) {
        this.personId = personId;
        this.personName = personName;
        this.personPwd = personPwd;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonPwd() {
        return personPwd;
    }

    public void setPersonPwd(String personPwd) {
        this.personPwd = personPwd;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", personPwd='" + personPwd + '\'' +
                '}';
    }
}
