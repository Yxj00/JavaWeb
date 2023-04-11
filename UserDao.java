package com.icss.dao;

import com.icss.pojo.User;

import java.util.List;

public interface UserDao {
    // 查询user的总个数
    int selectCount();
// 分页查询的抽象接口
    List<User> selectUserByLimit(int startIndex,int count);
}
