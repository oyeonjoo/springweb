package com.my.spring.web.ch02.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // mvc 프레젠테이션 계층에서는 클라이언트와 대화를 해야한다
@RequestMapping("ch02/ex01")
public class UserController {
	@GetMapping("11")
	public ModelAndView handler11(ModelAndView mv) { // 핸들러맵핑에 등록된다. 다른리퀘스트가 들어오면 맵핑되지 않는다
		mv.addObject("user", new User("최한석", 11));
		mv.setViewName("ch02/ex01/user"); // @GetMapping이 붙어있어야 핸들러이다
		
		return mv; // 컨트롤러의 역할은 여기서 끝, mv객체는 디스패쳐가 받는다, 모델 앤 뷰 리턴
	} // http://localhost/ch02/ex01/11 실행
	
	@GetMapping("21")
	public String handler21(Model model) { // 컨테이너가 model타입의 객체를 넣어준다
		model.addAttribute("user", new User("한아름", 21));
		return "ch02/ex01/user"; // string 리턴
	}
	
	@GetMapping("22")
	public String handler22() { // model은 리턴하지 않겠다, string 리턴(뷰)
		return "ch02/ex01/user";
	}
	
	@GetMapping("31")
	public void handler31(User user) { // domain을 써준다 > 컨테이너가 User 객체를 만들어서 넣어준다(기본생성자 이용)
		user.setUserName("양승일");
		user.setAge(31);
	}
	
	@GetMapping("32")
	public void handler32(@ModelAttribute("man")User user) {
		user.setUserName("서준한");
		user.setAge(32);
	}
	
	@GetMapping("41")
	public User handler41(User user) {
		user.setUserName("김가람");
		user.setAge(41);
		
		return user;
	}
	
	@GetMapping("42")
	@ModelAttribute("man") // 모델네임 직접 지정
	public User handler42(User user) {
		user.setUserName("박건우");
		user.setAge(42);
		
		return user; // 리턴타입: 모델
	}
} // 컨트롤러 하나에 핸들러 n개
