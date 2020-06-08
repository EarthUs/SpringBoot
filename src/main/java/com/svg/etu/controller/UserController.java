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
	 * 유저 리스트를 가져옴
	 * @return List<UserVO>
	 */
	@RequestMapping(method=RequestMethod.GET, value = "")
	public UserVO getUser() {
		return userService.getUser();
	}
}
