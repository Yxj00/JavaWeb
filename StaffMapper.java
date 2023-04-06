package com.icss.mapper;

import com.icss.pojo.Staff;

import java.util.List;

public interface StaffMapper {
    /**
     * 查询所有员工  并关联查询
     * @return
     */
    List<Staff> selectAll();
}
