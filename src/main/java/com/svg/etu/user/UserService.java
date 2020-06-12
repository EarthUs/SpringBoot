package com.svg.etu.user;

import java.util.Optional;

public interface UserService {
	/*
	 * 소셜 로그인으로 반환되는 값 중 email을 통해 이미 생성된 사용자인지 처음 가입하는 사용자인지 판단하기 위한 함수
	 */
	int findByEmail(String email);

	/*
	 * User 정보 수정 및 삽입
	 */
	UserVO saveUser(UserVO vo);

	/*
	 * User 정보를 가져오는 함수
	 */
	UserVO getUser(int id);
	
	/*
	 * User 삽입
	 */
	void insertUser(UserVO vo);
	
	/*
	 * User 정보 수정
	 */
	void updateUser(UserVO vo);
	
	/*
	 * User 정보 삭제
	 */
	void deleteUser(UserVO vo);
}
