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
public interface UserMapper {
	
	
	//基于annotation的方法 就不需要UserMapper.xml了
	//使用@Insert注解指明add方法要执行的SQL  
    @Insert("insert into User(name, age) values(#{name}, #{age})")
    public int addUser(User user);

    //使用@Delete注解指明deleteById方法要执行的SQL
    @Delete("delete from User where id=#{id}")
    public int deleteUser(int id);

    //使用@Update注解指明update方法要执行的SQL
    @Update("update User set name=#{name},age=#{age} where id=#{id}")
    public int updateUser(User user);

    //使用@Select注解指明getUser方法要执行的SQL
    @Select("select * from User where id=#{id}")
    public User getUser(int id);

    //使用@Select注解指明getAll方法要执行的SQL
    @Select("select * from User")
    public List<User> getAllUsers();
    
    @Delete("delete from User where age=#{age}")
    public int deleteUserByage(int age);
    
   
}
