package com.svg.etu.user;

public interface UserDAO {
	/*
	 * User 정보를 가져오는 함수
	 */
	public UserVO getUser(UserVO vo);
	
	/*
	 * User 삽입
	 */
	public void insertUser(UserVO vo);
	
	/*
	 * User 정보 수정
	 */
	public void updateUser(UserVO vo);
	
	/*
	 * User 정보 삭제
	 */
	public void deleteUser(UserVO vo);
}
