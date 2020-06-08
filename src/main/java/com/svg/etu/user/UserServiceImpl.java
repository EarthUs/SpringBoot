package com.svg.etu.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public UserVO getUser() {
		System.out.println("----------[getUser 함수 호출]----------");
		UserVO user = sqlSessionTemplate.selectOne("getUser"); 
		return user;
	}
	
	
}
