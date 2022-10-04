package com.my.spring.web.ch05.ex01;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.my.spring.web.ch05.domain.User;

// 모델과 뷰가 아닌 json을 리턴해야한다
@RestController("ch05.ex01") // 모델만 리턴하는데 그 모델의 형태는 json이다
@RequestMapping("ch05/ex01")
public class UserController {
	@GetMapping("main") // model and view를 쓴다
	public ModelAndView main(ModelAndView mv) {
		mv.setViewName("ch05/ex01/main");
		return mv;
	}
	
	@GetMapping("get") // 읽기
	public User get(User user) {
		return user;
	}
	
	@PostMapping("post") // 추가
	public User post(@RequestBody User user) {
		return user;
	}
	
	@PutMapping("put") // 수정
	public User put(@RequestBody User user) {
		return user;
	}
	
	@PatchMapping("patch") // 수정
	public User patch(@RequestBody User user) {
		return user;
	}
	
	@DeleteMapping("delete") // 삭제
	public User delete(@RequestBody User user) {
		return user;
	}
}
