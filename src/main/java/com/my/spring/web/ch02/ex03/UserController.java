package com.my.spring.web.ch02.ex03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("ch02.ex03")
@RequestMapping("ch02/ex03/user") // userIn과 userOut에 같이 할당된다
public class UserController { // 업무별로 url을 할당, url이 같으면 하나의 업무이다
	@GetMapping
	public String userIn() {
		return "ch02/ex03/userIn";
	}
	
	//@PostMapping
	public String userOut(User user) { // User는 커맨드, 멤버변수로 잘 들어간다
		return "ch02/ex03/userOut";
	} // 소문자 user 모델이 자동으로 적용된다
}
// 일반 컨트롤러와 뷰 컨트롤러가 url이 동일하다면, 1차적으로 일반 컨트롤러를 먼저 사용한다.
// 커맨드 하나로 선언하는 것이 깔끔하다