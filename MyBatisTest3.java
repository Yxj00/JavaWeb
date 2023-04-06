package com.icss.test;

import com.icss.mapper.StaffMapper;
import com.icss.pojo.Staff;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest3 {
    private static SqlSessionFactory sqlSessionFactory ;

    static {
        InputStream is =null;
        // 读取配置文件 mybatis-config.xml,获取输入流
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
@Test
    public void testSelectAll(){
    SqlSession sqlSession = sqlSessionFactory.openSession();
    StaffMapper mapper = sqlSession.getMapper(StaffMapper.class);
    List<Staff> staffList=mapper.selectAll();
    for (Staff staff : staffList) {
        System.out.println(staff);
        System.out.println(staff.getUser1());
        System.out.println(staff.getCardList());
    }
    sqlSession.close();
}
}
