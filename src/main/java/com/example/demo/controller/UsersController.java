package com.example.demo.controller;

import com.example.demo.service.JoinService;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UsersController {

	@Autowired
	private JoinService joinService;

	@Autowired
	private LoginService loginService;

	@PostMapping("/joinRequest")
	public String joinRequest(@RequestParam Map<String, String> param) {
		String userId = param.get("user_id");
		String userPw = param.get("user_pw");
		String userName = param.get("user_name");

		String page = joinService.joinUser(userId, userPw, userName);
		return page;

	}

	@PostMapping("/loginRequest")
	public String loginRequest(@RequestParam Map<String, String> param) {
		String userId = param.get("user_id");
		String userPw = param.get("user_pw");

		String page = loginService.login(userId, userPw);

		return page;
	}
}
