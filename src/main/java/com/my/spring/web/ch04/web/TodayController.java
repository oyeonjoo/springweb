package com.my.spring.web.ch04.web;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.my.spring.web.ch04.service.TodayService;

@Controller // 이 컨트롤러의 디펜던시는
public class TodayController {
	@Autowired private TodayService todayService;
	
	@GetMapping("ch04/today") // view
	@ModelAttribute("today")
	public LocalDate today() {
		return todayService.getToday(); // model 리턴, 서비스의 리턴값은 model
	}
}
