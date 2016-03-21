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
		
		//mybatis�����ļ�
		String resource = "configuration.xml";
		
		//�õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//�����Ự����������mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		/**
		 * ͨ��sqlSession�������ݿ�
		 * ��һ��������ӳ���ļ���statement��id��= namespace + "." + statement's id
		 * �ڶ���������ָ����ӳ���ļ���ƥ���parameterType���͵Ĳ���
		 * ����ֵ���ͣ�����ӳ���ļ�����ƥ���resultType���͵Ķ���
		 */
		User user = sqlSession.selectOne("test.findByName", "");
		
		System.out.println(user);
		
		//�ͷ���Դ
		sqlSession.close();
	}

}
