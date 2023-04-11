package com.icss.pojo;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
    private int currentPage;// 当前页
    private int totalPage;// 总页数
    private int count; // 每页显示的条数
    private int  totalCount;// 总的数据的条数
    private List<User> users=new ArrayList<>();

    public PageBean() {
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
