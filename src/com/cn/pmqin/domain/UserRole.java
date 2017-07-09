/**
 * 
 */
package com.cn.pmqin.domain;
/** 
* @author : pmqin
* @date   : 2016年1月14日 下午5:22:05 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class UserRole {
	//定义实体类的属性，与UserRole表中的字段对应
	private int id;            //id===>R_ID
    private String name;    //name===>R_Name
	@Override
	public String toString() {
		return "UserRole [id=" + id + ", name=" + name + "]";
	}
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
}
