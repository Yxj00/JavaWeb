package com.icss.Mapper;

import com.icss.pojo.Brand;
import com.icss.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User>selectAll();
/**
 * mybatis 参数封装
 *  *单个参数
 *      1.POJO类型  :直接使用  属性名 和参数占位符名称一致
 *      2.Map集合： 直接使用 键名 和 参数占位符名称一致
 *      3.Collection  ：封装map集合 可以使用@param注解，替换map集合中默认的arg键名
 *          map.put("arg0",collection集合);
 *          map.put("collection",collection集合);
 *      4.List  封装map集合 可以使用@param注解，替换map集合中默认的arg键名
 *       map.put("arg0",list集合);
 *          map.put("list",list集合);
 *      5.Array  封装map集合 可以使用@param注解，替换map集合中默认的arg键名
 *           map.put("arg0",数组);
 *          map.put("array",数组);
 *      6.其他类型 直接使用
 *   *多个参数 :f封装为map集合
 *          map.put("arg0",参数值1);  username=#{arg0}
 *          或
 *          map.put("param1",参数值1);
 */
User select(@Param("username") String username,@Param("password") String password);
}
