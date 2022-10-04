package com.my.spring.web.ch02.ex03;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
	private String userName;
	private int age;
	@DateTimeFormat(pattern="yyyy-MM-dd") // User를 커맨드로 쓰려고 넣은 것이다
	private LocalDate regDate;
}
// 커맨드: 파라미터와 일치하는 것을 도메인으로 가진 > 컨테이너가 알아서 멤버변수값으로 인젝션한다