package com.svg.etu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.svg.etu.user.UserService;
import com.svg.etu.user.UserVO;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	/*
	 * 유저 정보를 가져옴
	 * @return UserVO
	 */
	@RequestMapping(method=RequestMethod.GET)
	public UserVO getUser(UserVO vo) {
		return userService.getUser();
	}
	
	/*
	 * 유저 정보를 삽입
	 */
	@RequestMapping(method=RequestMethod.POST)
	public void insertUser(UserVO vo) {
		userService.insertUser(vo);
	}
	
	/*
	 * 유저 정보를 수정
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public void updateUser(UserVO vo) {
		userService.updateUser(vo);
	}
	
	/*
	 * 유저 정보를 삭제
	 */
	@RequestMapping(method=RequestMethod.DELETE)
	public void deleteUser(UserVO vo) {
		userService.deleteUser(vo);
	}
}
