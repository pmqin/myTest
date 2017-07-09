/**
 * 
 */
package com.cn.pmqin.domain;

import java.util.List;

/** 
* @author : pmqin
* @date   : 2016年1月4日 下午6:02:23 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class User {

	// 实体类的属性和表的字段名称一一对应
	private int id;
	private int roleId;
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}



	private String name;
	private int age;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	      * User表中有一个Role_ID字段，所以在User类中定义一个userRole属性，
	      * 用于维护UserRole和User之间的一对一关系，通过这个UserRole属性就可以知道这个
	     */
	private UserRole userRole;
	
   
	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	//使用一个List<Order>集合属性表示多个订单
	private List<Order> orders;
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", roleId=" + roleId + ", name=" + name + ", age=" + age + ", userRole=" + userRole
				+ ", orders=" + orders + "]";
	}
	
}
