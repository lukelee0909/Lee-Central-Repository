package org.lee.mybatis.first;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.lee.mybatis.bean.User;

public class MybatisFirst {
	
	public void findUserByNameTest() throws IOException{
		
		//mybatis配置文件
		String resource = "configuration.xml";
		
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		/**
		 * 通过sqlSession操作数据库
		 * 第一个参数：映射文件中statement的id，= namespace + "." + statement's id
		 * 第二个参数：指定和映射文件所匹配的parameterType类型的参数
		 * 返回值类型：是与映射文件中所匹配的resultType类型的对象
		 */
		User user = sqlSession.selectOne("test.findByName", "");
		
		System.out.println(user);
		
		//释放资源
		sqlSession.close();
	}

}
