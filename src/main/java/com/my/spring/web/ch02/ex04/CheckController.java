package com.my.spring.web.ch02.ex04;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ch02/ex04")
public class CheckController {
	@GetMapping
	public String main() {
		return "ch02/ex04/main";
	}
	
	@GetMapping("choice")
	public String choice(int kind) { // @RequestParam
		String view = "ch02/ex04/";
		
		switch(kind) {
		case 1: view += "radioIn"; break;
		case 2: view += "checkboxIn";
		}
		
		return view; // 모델없이 뷰만 리턴한다
	}
	/*
	@PostMapping("radio")
	public String radio(String agree, Model model) {
		model.addAttribute("agree", agree);
		return "ch02/ex04/radioOut";
	}
	*/
	
	@PostMapping("radio") // 리퀘스트를 받아들이면서 그게 모델이 되도록
	public String radio(@ModelAttribute("agree") String agree) { // 수동으로 모델네임을 할당한 것이다
		return "ch02/ex04/radioOut";
	}
	/* 체크박스는 파라미터가 n개가 넘어온다 > ArrayList로 받는다
	@PostMapping("checkbox") // 기본생성자를 만들어서 넣어주는데, List는 인터페이스라 생성자가 없기 때문에 ArrayList를 쓴다
	public String checkbox(@RequestParam ArrayList<String> fruit) { // 파라미터 밸류가 n개이면 list를 쓴다, fruit은 투입이 되지 않는다
		System.out.println(fruit); // 파라미터네임과 통일-리퀘스트파라미터임을 선언, 리퀘스트 파라미터를 받을 수 있게 수정한다
		return null;
	} // 리퀘스트파람을 선언해 주어야 작동이 된다
	*/
	
	/*
	@PostMapping("checkbox")
	public String checkbox(@RequestParam("fruit") List<String> fruits) { // 다르게 적고 싶으면 @RequestParam
		System.out.println(fruits); // 리퀘스트파람인줄 아는 상태에서는 List도 문제없이 작동한다
		return null; // 리턴타입이 void가 아니면 널을 적어주어야한다
	}
	*/
	
	@PostMapping("checkbox")
	public String checkbox(@RequestParam("fruit") List<String> fruits, Model model) { // 모델을 파라미터로 준비한다
		model.addAttribute("fruits", fruits); // model을 준비해서 처리
		return "ch02/ex04/checkboxOut"; 
	}
}