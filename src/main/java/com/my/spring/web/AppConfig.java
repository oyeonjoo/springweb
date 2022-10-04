package com.my.spring.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer{
	@Value("${attachPath}") // 내가 등록한 패스를 쓰고 싶으면, @Value에 el로 표현하면 된다
	private String attachPath;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("ch01/main");
		//registry.addViewController("ch03/ex03/user").setViewName("ch02/ex03/userIn");
	} 
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("res/**").addResourceLocations("WEB-INF/res/");
		registry.addResourceHandler("attach/**").addResourceLocations("file:///" + attachPath + "/");
		// 프로토콜이름이 file인 것이다 > windows가 처리할 것이다
	}
}

// ViewControllers: 스프링에서 이미 존재하는 것
// view의 name이 ch01/main인 것을 리턴하면된다(디스패쳐에게 리턴해준다)
// > 디스패쳐가 ch01/main의 해석을 view resolver에게 의뢰한다
// > resolver가 리턴하는 값은 main.jsp이다 > url까지 리퀘스트에 넘긴다
// > 서블릿이 리스폰스를 클라이언트에게 넘긴다