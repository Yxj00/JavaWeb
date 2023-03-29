package com.csi.dao.impl;

import com.csi.dao.MasterDao;
import com.csi.pojo.Master;
import com.csi.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 接口实现类
 */
public class MasterDaoImpl implements MasterDao {
    // 实现数据链路层 连接数据库操作数据
    // 实例化方法
    DBUtil db=null;
    Statement stmt=null;
    PreparedStatement prep=null;
    ResultSet rs=null;// 结果集
    @Override
    public List<Master> selectAll() {
        // 创建一个用于存储查询数据的一个集合
        List<Master> list=new ArrayList<>();
        // 加载驱动
        try {
            db=new DBUtil();
            // 通过stmt传递数据
            stmt= db.getStmt();
            // 创建查询语句
            String sql="select * from master";
            // 获取结果集
            rs=stmt.executeQuery(sql);
            // 遍历每一条数据
            while (rs.next()){
                list.add(new Master(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getInt("money") ));
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
                    if (rs!=null)rs.close();
                    if (stmt!=null)stmt.close();
                    if (db!=null)db.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

        }

    }

    @Override
    public boolean add(Master master) {
        try {
            db=new DBUtil();
            prep=db.getPrep("insert into master(name,password,money) values(?,?,?)");
            prep.setString(1,master.getName());
            prep.setString(2,master.getPassword());
            prep.setInt(3,master.getMoney());
            prep.executeUpdate();
            return true;

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
                    if (prep!=null)  prep.close();
                    if (db!=null) db.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

        }

    }

    @Override
    public Master selectById(int id) {
        try {
            db=new DBUtil();
            prep=db.getPrep("select * from master where id=?");
            prep.setInt(1,id);
            rs=prep.executeQuery();
            while (rs.next()){
                Master master = new Master(rs.getInt("id"), rs.getString("name"),
                        rs.getString("password"),
                        rs.getInt("money"));
                return master;
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean update(Master master) {
        try {
            db=new DBUtil();
            prep= db.getPrep("update master set name=?,password=?,money=? where id=?");
            prep.setString(1,master.getName());
            prep.setString(2,master.getPassword());
            prep.setInt(3,master.getMoney());
            prep.setInt(4,master.getId());
            prep.executeUpdate();
            return true;
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
                if (prep!=null)  prep.close();
                if (db!=null) db.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public boolean remove(int id) {
        try {
            db=new DBUtil();
            prep= db.getPrep("delete from master where id=?");
            prep.setInt(1,id);
            prep.executeUpdate();
            return true;
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
                if (prep!=null)  prep.close();
                if (db!=null) db.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }

    @Override
    public Master selectByUsernameAndPassword(String username, String password) {
        return null;
    }


}
