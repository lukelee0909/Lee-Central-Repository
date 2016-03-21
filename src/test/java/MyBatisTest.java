

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.lee.mybatis.bean.User;
import org.lee.mybatis.dao.UserMapper;


/**
 * myBatis数据库测试
 * 
 * 
 */
public class MyBatisTest {
	
	/**
	 * 获得MyBatis SqlSessionFactory  
	 * SqlSessionFactory负责创建SqlSession，一旦创建成功，就可以用SqlSession实例来执行映射语句，commit，rollback，close等方法。
	 * @return
	 */
	private static SqlSessionFactory getSessionFactory() {
		SqlSessionFactory sessionFactory = null;
		String resource = "configuration.xml";
		try {
			sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}

	public static void main(String[] args) {
		SqlSession sqlSession = getSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		User userQuery = new User();
//		userQuery.setUuid("abc");
//		userQuery.setName("xl");
//		// test select
//		User user = userMapper.findByName(userQuery);
//		System.out.println(user.getAge());
		
//		// test update
//		User user1 = new User();
//		user1.setName("andy");
//		user1.setAge(33);
//		user1.setUuid("3333333333333");
//		userMapper.updateUser(user1);
//		System.out.println(user1.getAge());
//		System.out.println(user1.getUuid());
////		sqlSession.rollback();
//		sqlSession.commit();
		
		// test insert
//		User user1 = new User();
//		user1.setName("andy");
//		user1.setAge(22);
//		user1.setUuid("1111111111111111");
//		userMapper.insertUser(user1);
//		System.out.println(user1.getId());
//		System.out.println(user1.getUuid());
//		sqlSession.commit();

		sqlSession.close();
	}

}