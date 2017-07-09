/**
 * 
 */
package com.cn.pmqin.domain;
/** 
* @author : pmqin
* @date   : 2016年1月17日 下午9:21:49 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 * 最好不要使用order名称当数据库的表名 
 *
 */
public class Order {
  
	private int id;            //id===>od_id
    private String name;    //name===>od_name
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
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + "]";
	}
	
}
