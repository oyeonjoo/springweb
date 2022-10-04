package com.my.spring.web.ch03.ex02;

import lombok.Data;

@Data
public class User {
	private String userName;
	private int age;
	private String faceFilename; // 첨부파일의 파일네임이 필요하다, db와 대화하려고 만든것이다(db관점에서는 String이다)
}
