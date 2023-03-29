package com.csi.pojo;

/**
 * pojo entiry都代表实体
 */
public class Master {
    private Integer id;
    private String name;
    private String password;
    private Integer money;

    public Master() {
    }

    /**
     * 无id构造方法
     * @param name
     * @param password
     * @param money
     */
    public Master(String name, String password, Integer money) {
        this.name = name;
        this.password = password;
        this.money = money;
    }

    public Master(Integer id, String name, String password, Integer money) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Master{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }
}
