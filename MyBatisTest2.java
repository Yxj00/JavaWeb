package com.icss.test;

import com.icss.mapper.PersonMapper;
import com.icss.pojo.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest2 {
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
        // 获取会话接口
        SqlSession sqlSession=sqlSessionFactory.openSession();
        // 获取mapper
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        // 调用方法
        List<Person> list = mapper.selectAll();
        for (Person person : list) {
            System.out.println(person);
        }
        // 关闭session
        sqlSession.close();
    }
}
