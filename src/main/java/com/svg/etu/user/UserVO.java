package com.svg.etu.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter // 클래스 내 모든 필드의 Setter 메소드를 자동생성
@Getter // 클래스 내 모든 필드의 Getter 메소드를 자동생성
@NoArgsConstructor // 기본 생성자 자동 추가
public class UserVO {
	private int id;
	private String name; // 추가, social_type 삭제
	private String img;
	private String nick_name;
	private String email;
	private Role role;
	private int location; // 현재 위치
	private int steps; // 총 걸음 수
	private Timestamp created_at; // 계정 등록 시간

	@Builder
	public UserVO(String name, String img, String nick_name, String email, Role role, int location, int steps, Timestamp created_at) {
		this.name = name;
		this.img = img;
		this.nick_name = nick_name;
		this.email = email;
		this.role = role;
		this.steps = steps;
		this.location = location;
	}

	public UserVO update(String img, String nick_name) {
		this.img = img;
		this.nick_name = nick_name;

		return this;
	}
}

// findByEmail 추가하기 : 소셜 로그인으로 반환되는 값 중 email을 통해 이미 생성된 사용자인지 처음 가입하는 사용자인지 판단하기 위한 메소드