package com.my.spring.web.ch03.ex02;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data // accessor
public class UserDto {
	private String userName;
	private int age;
	private MultipartFile face; // 클라이언트의 관점, 바이너리이면 MultipartFile를 쓴다
}
