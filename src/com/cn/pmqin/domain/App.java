/**
 * 
 */
package com.cn.pmqin.domain;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
/*import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;*/
import org.omg.CORBA.INTERNAL;

import com.cn.pmqin.dao.UserMapper;
import com.cn.pmqin.dao.UserMapper1;
import com.cn.pmqin.util.MyBatisUtil;

/** 
* @author : pmqin
* @date   : 2016年1月4日 下午8:51:27 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//系列  http://www.cnblogs.com/xdp-gacl/p/4262895.html
		// mybatis的配置文件
		// String resource = "conf.xml";//默认获取src的根目录
		// InputStream is =	 App.class.getClassLoader().getResourceAsStream(resource);
		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		//
		// 构建sqlSession的工厂
		// SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		// SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 创建能执行映射文件中sql的sqlSession
		// SqlSession session = sessionFactory.openSession();
	    
		//执行查询返回一个唯一user对象的sql，第一种全部使用配置文件，不需要接口		
		// 使用工具类,注意我这里只是为了减小代码量，最好是把SqlSession放在方法体内，因为SqlSession是线程不安全的
		SqlSession session = MyBatisUtil.GetSqlSession(true);
		String statement1 = "com.cn.pmqin.mapping.UserMapper.getUser";//映射sql的标识字符串           
        User user1 = session.selectOne(statement1, 1);
        System.out.println(user1);
        
        //扩展，采用注解的语句形式
        String statementce = "com.cn.pmqin.dao.UserMapper.getUser";
        User userce = session.selectOne(statementce, 1);
        //session1.commit();//不懂为啥，这个地方一定要提交事务之后二级缓存才会起作用 因为，二级缓存是从cache（mapper.xml中定义的cache）中取得，如果session不commit，那么数据就不会放入cache中。所以，只有commit后，才能取得
        System.out.println("采用注解的语句形式:"+userce);
        
		//第二種方式基于注解的实现
		selectTest(session);
//		addTest(session);
//		updateTest(session);
//		deleteTest(session);
//		loadTest(session);
//		listTest(session);
		
        //第三种方式 也就是企业级一般的使用方式，配置文件里面的命名空间配置dao层的完全限定名称
		//接口的方法名称和配置文件的ID的方法名称必须一致，采用动态代理方式
		UserMapper1 mapper = session.getMapper(UserMapper1.class);
		User good = mapper.getUser(7);
		System.out.println(good);
		System.out.println("MyBatis 能延迟加载这样的查询就是一个好处,因此你可以分散这些语句同时运行的消 耗，注意要设置参数才起作用");
		
		List<User> goods = mapper.getUsersByage(111);
		for (User user : goods) {
			System.out.println(user);
		}
		
		/**
		 * 映射sql的标识字符串， com.cn.pmqin.mapping.UserMapper是UserMapper.
		 * xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		
		
//		//一对一，多的关系 执行查询返回一个唯一user对象的sql
		String statement2 = "com.cn.pmqin.mapping.UserMapper2.getUser0";// 映射sql的标识字符串		
		User user2 = session.selectOne(statement2, 1);
		System.out.println("一对一关系，定义了别名com.cn.pmqin.domain.UserRole ， 就要使用 javaType=Role:"+user2);

		String statement3 = "com.cn.pmqin.mapping.UserMapper2.getUser";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		User user3 = session.selectOne(statement3, 2);
		System.out.println("关系2"+user3);
		
		
		/*存储过程的调用 注意map关系 resultMap="UserResultMap"*/
		System.out.println("MyBatis 存储过程的调用");
		String statement = "com.cn.pmqin.mapping.UserMapper2.getUsers";//映射sql的标识字符串
        Map<String, Integer> parameterMap = new HashMap<String, Integer>();
        parameterMap.put("AgeNUM", 5);
        List<User> us=session.selectList(statement, parameterMap);
        System.out.println(us.size()+"条记录被存储过程获取");
		for (User user : us) {
			System.out.println(user);
		}
        Integer result = parameterMap.get("usercount");
        System.out.println(result);
       
		//session.close();
		//session.clear();
	}

	
	public static void selectTest(SqlSession session) {
		
		//执行查询返回一个唯一user对象的sql，第一种全部使用配置文件，不需要接口
		//String statement = "com.cn.pmqin.mapping.UserMapper.getUser";//映射sql的标识字符串
		//User good = session.selectOne(statement, 1);
		UserMapper mapper = session.getMapper(UserMapper.class);		
		User good = mapper.getUser(2);
		System.out.println(good);
	}
	public static void addTest(SqlSession session) {

		try {
			User u = new User();
			for (int i = 0; i < 5; i++) {
				u.setName("注解名" + i);
				u.setAge(i + 1);
				//第一种全部使用配置文件，不需要接口 ,映射sql的标识字符串
				//int retResult = session.insert("com.cn.pmqin.mapping.UserMapper.addUser",);				
				// 基于注解的实现 ,不需要UserMapper.xml 
				//第三种：xml里面的命名空间必须跟接口类一样 <mapper namespace="com.cn.pmqin.dao.UserMapper">
				UserMapper mapper = session.getMapper(UserMapper.class);
				int add = mapper.addUser(u);

			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// MyBatisUtil.closeSeqSession(session);
		}
	}

	public static void updateTest(SqlSession session) {

		try {
			User u = new User();
			u.setName("注解更新成功");
			u.setAge(111);
			//u.setRoleId(1);
			u.setId(1);
			//第一种全部使用配置文件，不需要接口 ,映射sql的标识字符串
			// session.update("com.cn.pmqin.mapping.UserMapper.updateUser", u);
			// session.commit();

			// 基于注解的实现，,不需要UserMapper.xml 
			//第三种：xml里面的命名空间必须跟接口类一样 <mapper namespace="com.cn.pmqin.dao.UserMapper">
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.updateUser(u);
			//清空缓存
			session.commit();
			System.out.println("updateTest成功" + u);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// MyBatisUtil.closeSeqSession(session);
		}
	}

	public static void deleteTest(SqlSession session) {

		try {

			User u = new User();
			u.setId(1);
			// 第一种全部使用配置文件，不需要接口 ,映射sql的标识字符串
			// row=session.delete("com.cn.pmqin.mapping.UserMapper.deleteUser",u);
			// session.commit();

			// 基于注解的实现,,不需要UserMapper.xml 
			//第三种 ：xml里面的命名空间必须跟接口类一样 <mapper namespace="com.cn.pmqin.dao.UserMapper">
			UserMapper mapper = session.getMapper(UserMapper.class);
			Integer rows = 0;
			for (int i = 1; i <=3; i++) {
				//Integer row = mapper.deleteById(i);
				Integer row = mapper.deleteUserByage(i);
				rows += row;
			}
			System.out.println("deleteTest成功删除" + rows+"条记录");// 删除影响的行数
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// MyBatisUtil.closeSeqSession(session);
		}
	}

	public static void loadTest(SqlSession session) {
		// SqlSession session = null;
		try {
			// session = MyBatisUtil.createSeqSession();
			//原始方式
			//User u = (User) session.selectOne("com.cn.pmqin.mapping.UserMapper.getUser", 7);
			//Mybatis注解  ,不需要UserMapper.xml 
			User u = (User) session.selectOne("com.cn.pmqin.dao.UserMapper.getUser", 5);
			System.out.println("第五条记录" + u); // 查不到就是null
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// MyBatisUtil.closeSeqSession(session);
		}
	}

	public static void listTest(SqlSession session) {
		
		try {
			
			// 无参数
			// List<User> us=session.selectList("com.cn.pmqin.mapping.UserMapper.getAllUsers");
			// 有参数 注意 配置文件里面 指定参数类型 parameterType="int" 或者 对象parameterType="User"
			// List<User> us =session.selectList("com.cn.pmqin.mapping.UserMapper.getUsersByage",7);

			// 基于注解的实现,不需要UserMapper.xml 
			UserMapper mapper = session.getMapper(UserMapper.class);
			List<User> us = mapper.getAllUsers();

			System.out.println(us.size());
			for (User user : us) {
				System.out.println(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// MyBatisUtil.closeSeqSession(session);
		}
	}

}
