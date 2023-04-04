package com.icss.test;


import com.icss.mapper.PersonMapper;
import com.icss.mapper.UserMapper;
import com.icss.pojo.Person;
import com.icss.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    private static   SqlSessionFactory sqlSessionFactory ;

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
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 调用方法
        List<User> list = mapper.selectAll();
        for (User user : list) {
            System.out.println(user);

        }
        // 关闭session
        sqlSession.close();
    }

    @Test
    public void testAdd(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUsername("小黄2");
        user.setPassword("3333");
        user.setGender("男");
        user.setAddr("天津");
        System.out.println(user);
        mapper.addUser(user);
        sqlSession.close();
        System.out.println(user);
    }
    @Test
    public void testUpdate(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(7);
        user.setUsername("孙浩晨");
        user.setAddr("扎兰屯");
        mapper.updateUser(user);
        sqlSession.close();
    }
    @Test
    public void testDeleteById(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteById(6);
        sqlSession.close();
    }
    @Test
    public void testCount(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.count();
        System.out.println(count);
        sqlSession.close();
    }

    @Test
    public void testUsernameLike(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String username="浩";
        username="%"+username+"%";
        User user = new User();
        user.setUsername(username);
        List<User> users = mapper.usernameLike(user);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void testSelectByUsernameAndPassword(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User sun = mapper.selectByUsernameAndPassword("孙浩晨", "3333");
        System.out.println(sun);
        sqlSession.close();

    }
    @Test
    public void testSelectOrderByDesc(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectOrderByDesc("id");
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();

    }

}
