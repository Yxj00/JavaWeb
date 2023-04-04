package com.icss.mapper;

import com.icss.pojo.Person;

import java.util.List;

public interface PersonMapper {
    /**
     * 查询所有
     * @return
     */
    List<Person> selectAll();
}
