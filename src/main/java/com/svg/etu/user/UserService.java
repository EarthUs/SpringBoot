package com.svg.etu.user;

public interface UserService {
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
