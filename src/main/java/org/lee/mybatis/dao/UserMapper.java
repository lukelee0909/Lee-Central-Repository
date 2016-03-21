package org.lee.mybatis.dao;

import java.util.List;

import org.lee.mybatis.bean.User;

public interface UserMapper {
	
	public User findByName(User user);

	public void insertUser(User user);
	
	public List<User> findByName();
	
	public void updateUser(User user);
	//public void deleteUser(String name);
}
