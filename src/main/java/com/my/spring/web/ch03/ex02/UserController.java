package com.my.spring.web.ch03.ex02;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller("ch03.ex02")
@RequestMapping("ch03/ex02/user")
public class UserController {
	@Value("${attachPath}") private String attachPath;

	@GetMapping
	public String userIn() {
		return "ch03/ex02/userIn";
	}
	
	@PostMapping
	public String userOut(UserDto userDto, HttpServletRequest request, User user) {
		// user는 db와 대화할 때 쓴다
		String fileName = userDto.getFace().getOriginalFilename();
		// 파일명을 뽑아낸다, 서버에 저장하면 파일명이 달라질 수도 있어서 getOriginal을 호출한다
		saveFile(attachPath + "/" + fileName, userDto.getFace());
		
		user.setFaceFilename(fileName);
		
		return "ch03/ex02/userOut"; // 모델은 없고 뷰만 리턴하고 끝난다
	} //클라이언트가 저장한 파일은 리퀘스트로 넘어온다(리퀘스트 바디에 저장되어서 온다) 클라이언트가 저장한 것은 파라미터이다
	// 파라미터 밸류의 타입이 스트링이 아니다 > 바이너리 형태이면 바디에 저장할 수 밖에 없다 > 리퀘스트 메소드는 포스트일 수 밖에 없다
	// 파일을 뽑아내려고 리퀘스트를 쓴다
	
	private void saveFile(String fileName, MultipartFile file) {
		try {
			file.transferTo(new File(fileName));
		} catch(IOException e) {}
	} // fileName에 파일명이 저장된다
}
