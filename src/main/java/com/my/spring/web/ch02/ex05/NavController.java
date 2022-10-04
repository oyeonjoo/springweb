package com.my.spring.web.ch02.ex05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ch02/ex05")
public class NavController {
	@GetMapping("forward")
	public String forward() {
		return "forward:target"; // target은 절대주소이다, 컨테이너는 target을 viewName으로 인지한다 > 404 에러 > 접두사로 forward를 붙여준다
	} // url을 리턴
	
	@GetMapping("target")
	public String target() { 
		return "ch02/ex05/target"; // viewName이다
	}
	
	@GetMapping("redirect")
	public String redirect() {
		return "redirect:target"; // target만 적으면 viewName으로 인지한다 > redirect: 를 써준다
	} // localhost/ch02/ex05/redirect를 적으면 서버단에는 http://localhost/ch02/ex05/target 로 뜬다

	@GetMapping("naver")
	public String naver() {
		return "redirect:https://naver.com";
	}
}
