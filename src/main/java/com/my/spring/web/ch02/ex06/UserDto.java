package com.my.spring.web.ch02.ex06;

import lombok.Data;

@Data // setter, getter를 만들어준다
public class UserDto {
	private String userId;
	private String pw;
}
