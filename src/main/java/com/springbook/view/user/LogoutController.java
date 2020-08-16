package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping(value="logout.do")
	public String handleRequest(HttpSession session) {
		System.out.println("로그아웃 처리");
		
		// 브라우저와 연결된 세션 객체 강제 종료
		session.invalidate();

		return "login.jsp";
	}
}
