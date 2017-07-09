/**
 * 
 */
package com.cn.pmqin.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.cn.pmqin.dao.UserMapper1;
import com.cn.pmqin.domain.User;
import com.cn.pmqin.service.IUserService;
import com.cn.pmqin.util.MyBatisUtil;

/** 
* @author : pmqin
* @date   : 2016年1月22日 上午11:28:13 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class UserServiceImp implements IUserService{

	/* (non-Javadoc)
	 * @see com.cn.pmqin.service.IUserService#addUser(com.cn.pmqin.domain.User)
	 */
	@Override
	public void addUser(User user) {
		SqlSession session = MyBatisUtil.GetSqlSession(true);
		UserMapper1 mapper = session.getMapper(UserMapper1.class);
		mapper.addUser(user);
		session.commit();
		session.close();
	}

	/* (non-Javadoc)
	 * @see com.cn.pmqin.service.IUserService#getUserById(java.lang.String)
	 */
	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		return null;
		/** 
		* @parameter  
		*/
	}

	/* (non-Javadoc)
	 * @see com.cn.pmqin.service.IUserService#getAllUser()
	 */
	@Override
	public List<User> getAllUser() {
		SqlSession session = MyBatisUtil.GetSqlSession(true);
		/*存储过程的调用 注意map关系 resultMap="UserResultMap"*/
		String statement = "com.cn.pmqin.mapping.UserMapper2.getUsers";//映射sql的标识字符串
        Map<String, Integer> parameterMap = new HashMap<String, Integer>();
        parameterMap.put("AgeNUM", 5);
        List<User> us=session.selectList(statement, parameterMap);
        session.close();
        return us;
	}

}
