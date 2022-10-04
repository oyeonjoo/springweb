package com.my.spring.web.ch05.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data // setter를 만들어준다
public class User {
	private int userId;
	private String userName;
	@DateTimeFormat(pattern="yyyy-MM-dd") //  LocalDate로 파싱, birthday를 넣을 때
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul") // LocalDate를 json으로 바꾼다, 클라이언트에게 보낼 때
	private LocalDate birthday;
}
