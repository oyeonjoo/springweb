package com.my.spring.web.ch05.ex02.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.spring.web.ch05.domain.User;
import com.my.spring.web.ch05.ex02.dao.map.UserMap;

@Repository("ch05.ex02.userDao") // 퍼시스턴스 계층임을 나타낸다
public class UserDaoImpl implements UserDao {
	@Autowired private UserMap userMap; // 컨테이너가 준비한 dao를 넣어주는 것이다
	
	@Override
	public List<User> selectUsers(){
		return userMap.selectUsers();
	}
	
	@Override
	public int insertUser(User user) {
		return userMap.insertUser(user);
	}
	
	@Override
	public int updateUser(User user) {
		return userMap.updateUser(user);
	}
	
	@Override
	public int deleteUser(int userId) {
		return userMap.deleteUser(userId);
	}
}
