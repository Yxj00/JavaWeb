package com.icss.dao.impl;

import com.icss.dao.UserDao;
import com.icss.pojo.User;
import com.icss.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public Connection conn=null;
    public DBUtil db=null;
    public ResultSet rs=null;
    public PreparedStatement pstmt=null;
    @Override
    public int selectCount() {
        try {
            db=new DBUtil();
            pstmt=db.getPrep("select count(*) totalCount from user");
            rs=pstmt.executeQuery();
            while (rs.next()){
                // 这里获取到数据
                // 通过列的顺序，顺序指的是select后面的数据
                // 字段顺序
                return rs.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
                try {
                    if (rs!=null) rs.close();
                    if (pstmt!=null) pstmt.close();
                    if (db!=null)db.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
        return 0;
    }

    @Override
    public List<User> selectUserByLimit(int startIndex, int count) {
        try {
            db=new DBUtil();
            pstmt= db.getPrep("select * from user limit ?,?");
            pstmt.setInt(1,startIndex);
            pstmt.setInt(2,count);
            rs=pstmt.executeQuery();
            List<User> list=new ArrayList<>();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                list.add(user);
            }
            return list;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (rs!=null) rs.close();
                if (pstmt!=null) pstmt.close();
                if (db!=null)db.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
