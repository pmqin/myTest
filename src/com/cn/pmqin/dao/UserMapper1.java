/**
 * 
 */
package com.cn.pmqin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cn.pmqin.domain.User;

/** 
* @author : pmqin
* @date   : 2016年1月4日 下午10:29:10 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public interface UserMapper1 {
	
	
    public int addUser(User user);

   
    public int deleteUser(int id);

   
    public int updateUser(User user);

   /* 如果是综合查询呢？包装对象UserDAO里面有一个User对象，那就是这个UserDAO里面的 属性对象.属性名称形式进行 #{user.id} 
    public User getUser(UserDAO user);*/
    
    public User getUser(int id);

   
    public List<User> getAllUsers();
    
   
    public int deleteUserByage(int age);
    
    public int getCountByage(int age);
//    MyBatis 能延迟加载这样的查询就是一个好处,因此你可以分散这些语句同时运行的消 耗
    public List<User> getUsersByage(int age);
    
   
}
