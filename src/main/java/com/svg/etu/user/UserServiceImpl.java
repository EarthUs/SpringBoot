package com.svg.etu.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public UserVO getUser(int id) {
		System.out.println("----------[getUser 함수 호출]----------");
		UserVO user = sqlSessionTemplate.selectOne("getUser"); 
		return user;
	}

	@Override
	public void insertUser(UserVO vo) {
		System.out.println("----------[insertUser 함수 호출]----------");
		sqlSessionTemplate.insert("insertUser", vo);
	}

	@Override
	public void updateUser(UserVO vo) {
		System.out.println("----------[updateUser 함수 호출]----------");
		sqlSessionTemplate.update("updateUser", vo);
	}

	@Override
	public void deleteUser(UserVO vo) {
		System.out.println("----------[deleteUser 함수 호출]----------");
		sqlSessionTemplate.delete("deleteUser", vo);
	}
	
	
}
