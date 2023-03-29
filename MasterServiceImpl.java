package com.csi.service.impl;

import com.csi.dao.MasterDao;
import com.csi.dao.impl.MasterDaoImpl;
import com.csi.pojo.Master;
import com.csi.service.MasterService;

import java.util.List;

public class MasterServiceImpl implements MasterService {
    // 设置和数据链路层的一个连接 dao
    private MasterDao dao=new MasterDaoImpl();
    @Override
    public List<Master> findAll() {
        return this.dao.selectAll();
    }

    @Override
    public boolean insert(Master master) {
        return this.dao.add(master);
    }

    @Override
    public Master findById(Integer id) {
        return this.dao.selectById(id);
    }

    @Override
    public boolean update(Master master) {
        return this.dao.update(master);
    }

    @Override
    public boolean delete(Integer id) {
        return this.dao.remove(id);
    }

    @Override
    public Master findByUsernameAndPassword(String username, String password) {
        return this.dao.selectByUsernameAndPassword(username,password);
    }


}
