package com.my.spring.web.ch04.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.my.spring.web.ch04.domain.Employee;
import com.my.spring.web.ch04.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired private EmployeeService employeeService; // 컨트롤러의 디펜던시는 서비스
	
	@GetMapping("ch04/employee/{employeeId}") // {}안의 값은 path variable이다
	public String getEmployee(@PathVariable int employeeId, Model model) {
		Employee employee = employeeService.getEmployee(employeeId);
		model.addAttribute("employee", employee);
		
		return "ch04/employee";
	}
} // path variable은 파라미터 네임과 일치해야한다
