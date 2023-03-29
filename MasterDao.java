package com.csi.dao;

import com.csi.pojo.Master;

import java.util.List;

/**
 * 对Master类的一个抽象接口
 */
public interface MasterDao {
// 查询所有
    List<Master> selectAll();
    // 新增
    boolean add(Master master);
    // 根据id查询
    Master selectById(int id);
    // 修改
    boolean update(Master master);
    // 删除
    boolean remove(int id);
    // 登录
    Master selectByUsernameAndPassword(String username,String password);
}


