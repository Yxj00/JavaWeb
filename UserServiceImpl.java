package com.icss.service.impl;

import com.icss.dao.UserDao;
import com.icss.dao.impl.UserDaoImpl;
import com.icss.pojo.PageBean;
import com.icss.pojo.User;
import com.icss.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
    @Override
    public PageBean selectPageBean(int currentPage, int count) {
        /**
         *分页查询，要的的结果pageBean
         * 在service 中要封装pageBean 对象中的属性要借助dao实现
         * currentPage 当前页查询第几页
         */
        // 创建pageBean
        PageBean pageBean = new PageBean();
        // 封装第几页
        pageBean.setCurrentPage(currentPage);
        // 封装count 每页显示几条数据
        pageBean.setCount(count);
        // 封装总的条数
        int totalCount = dao.selectCount();
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage((int) Math.ceil((double) totalCount/count));
        // 封装当前所有的用户列表，分页查询
        List<User> users=dao.selectUserByLimit((currentPage-1)*count,count);
        pageBean.setUsers(users);
        // 返回page
        return pageBean;
    }
}
