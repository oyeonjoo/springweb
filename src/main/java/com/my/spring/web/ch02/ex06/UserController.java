package com.my.spring.web.ch02.ex06;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("ch02/ex06")
@RequestMapping("ch02/ex06")
public class UserController {
	@GetMapping("login") 
	public String logIn(@CookieValue(required=false) String userId, // 쿠키밸류가 없으면 말고
			@ModelAttribute("user") UserDto user) {
		if(userId != null) user.setUserId(userId); // 쿠키가 없으면 실행되지 않는다
		return "ch02/ex06/login";
	} // 리퀘스트에 저장된 쿠키밸류를 읽는다
	
	@PostMapping("login")
	public String login(@ModelAttribute("user") UserDto user, String rememberMe,
			HttpSession session, HttpServletResponse response) {
		if(session.getAttribute("userId") == null)
			session.setAttribute("userId", user.getUserId());
		
		if(rememberMe != null && rememberMe.equals("on")) {
			Cookie cookie = new Cookie("userId", user.getUserId());
			cookie.setMaxAge(5);
			response.addCookie(cookie);
		}
		
		return "ch02/ex06/logout";
	}// @ModelAttribute와 @RequestParam은 같이 쓰면 효과가 없어서 @ModelAttribute만 쓴다
	 // 세션 객체 안에 아이디가 있으면 로그인 한 것으로 판단한다
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
} 