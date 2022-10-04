package com.my.spring.web.ch02.home;

import lombok.Setter;

@Setter // getter는 직접쓰고, setter만 lombok이 준비한다
public class Number { // 커맨드
	private double num;
	
	public double getNum() {
		return num + (int)(Math.random() * 10) / 10.0;
	}
}
