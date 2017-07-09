/**
 * 
 */
package com.cn.pmqin.service;

import java.util.List;

import com.cn.pmqin.domain.User;

/** 
* @author : pmqin
* @date   : 2016年1月22日 上午11:04:41 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public interface IUserService {

	void addUser(User user);
	User getUserById(String userId);
	List<User> getAllUser();
}
