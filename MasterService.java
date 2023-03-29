package com.csi.service;

import com.csi.pojo.Master;

import java.util.List;

public interface MasterService {
    List<Master> findAll();
    // 新增
    boolean insert(Master master);
    // 根据id查询
    Master findById(Integer id);
    // 修改
    boolean update(Master master);
    // 删除
    boolean delete(Integer id);
    Master findByUsernameAndPassword(String username,String password);

}
