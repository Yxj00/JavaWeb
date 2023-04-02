package com.icss.test;

import com.icss.Mapper.BrandMapper;
import com.icss.Mapper.UserMapper;
import com.icss.pojo.Brand;
import com.icss.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        // 1. 加载mybatis的核心配置文件获取SqlSessionFactory
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口的代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4.执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);
        // 5.释放资源
        sqlSession.close();
    }
    @Test
    public void testSelectById() throws IOException {
        //接收参数
        int id=1;
        // 1. 加载mybatis的核心配置文件获取SqlSessionFactory
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口的代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4.执行方法  主要改这里
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);
        // 5.释放资源
        sqlSession.close();
    }
    @Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status=1;
        String companyName="华为";
        String brandName="华为";
        //处理参数
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";
        // 第二种得封装
      /*  Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);*/
        // 第三种
        Map map = new HashMap();
//        map.put("status",status);
//        map.put("companyName",companyName);
        map.put("brandName",brandName);
        // 1. 加载mybatis的核心配置文件获取SqlSessionFactory
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口的代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4.执行方法  主要改这里
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);
        // 5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws IOException {
        //接收参数
        int status=1;
        String companyName="华为";
        String brandName="华为";
        //处理参数
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";
        // 第二种得封装
        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
        // 1. 加载mybatis的核心配置文件获取SqlSessionFactory
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口的代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4.执行方法  主要改这里
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);
        // 5.释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        //接收参数
        int status=1;
        String companyName="诺基亚手机";
        String brandName="诺基亚";
        String description="手机中的战斗机";
        int ordered=100;

        // 第二种得封装
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        // 1. 加载mybatis的核心配置文件获取SqlSessionFactory
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 2.获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//加true自动提交事务
        //3.获取Mapper接口的代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4.执行方法  主要改这里
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);
        // 要提交事务
//        sqlSession.commit();
        // 5.释放资源
        sqlSession.close();
    }
    @Test
    public void testUpdate() throws IOException {
        //接收参数
        int status=1;
        String companyName="诺基亚超能手机";
        String brandName="诺基亚";
        String description="手机中战斗机的战斗机";
        int ordered=200;
        int id=5;
        // 第二种得封装
        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);
        brand.setId(id);
        // 1. 加载mybatis的核心配置文件获取SqlSessionFactory
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 2.获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//加true自动提交事务
        //3.获取Mapper接口的代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4.执行方法  主要改这里
        int count = brandMapper.update(brand);
        System.out.println(count);
        // 要提交事务
//        sqlSession.commit();
        // 5.释放资源
        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
        //接收参数
        int id=7;
        // 1. 加载mybatis的核心配置文件获取SqlSessionFactory
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 2.获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//加true自动提交事务
        //3.获取Mapper接口的代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4.执行方法  主要改这里
        brandMapper.deleteById(id);
        // 要提交事务
//        sqlSession.commit();
        // 5.释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {
        //接收参数
        int[] ids={8,9,10};
        // 1. 加载mybatis的核心配置文件获取SqlSessionFactory
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 2.获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//加true自动提交事务
        //3.获取Mapper接口的代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4.执行方法  主要改这里
        brandMapper.deleteByIds(ids);
        // 要提交事务
//        sqlSession.commit();
        // 5.释放资源
        sqlSession.close();
    }

    /**
     * User中
     */
    @Test
    public void testSelet() throws IOException {
        // 1.获取sqlSessionFactory
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 2,获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 4.执行方法
        String username="zhangsan";
        String password="123";
        User user = userMapper.select(username, password);
        System.out.println(user);
        // 释放资源
        sqlSession.close();

    }
}
