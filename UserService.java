package com.icss.service;

import com.icss.pojo.PageBean;

public interface UserService {
    //业务层的分页查询
    PageBean selectPageBean(int currentPage,int count);
}
