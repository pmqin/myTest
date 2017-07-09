/**
 * 
 */
package com.cn.pmqin.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cn.pmqin.dao.UserMapper;

/** 
* @author : pmqin
* @date   : 2016年1月4日 下午9:29:06 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class MyBatisUtil {
	
	/**
     * 获取SqlSessionFactory
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory GetSqlSessionFactory() {
        String resource = "conf.xml"; ////默认获取src的根目录
        InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
  
        //factory.getConfiguration().addMapper(UserMapper.class);
        
        return factory;
    }
    
    /**
     * 获取SqlSession
     * @return SqlSession
     */
    public static SqlSession GetSqlSession() {
        return GetSqlSessionFactory().openSession();
//        Connection conn = session.connection();  可以获取到原始JDBC
//        PrepareStatement stmt = conn.prepareStatement(insertSql);
    }

    /**
     * 获取SqlSession
     * @param isAutoCommit
     *         true 表示创建的SqlSession对象在执行完SQL之后会自动提交事务
     *         false 表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用sqlSession.commit()提交事务
     * @return SqlSession
     */
    public static SqlSession GetSqlSession(boolean isAutoCommit) {
        return GetSqlSessionFactory().openSession(isAutoCommit);
    }
    
    public static void closeSeqSession(SqlSession sqlSession) {
        try {
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession = null;
        }
    }
}
