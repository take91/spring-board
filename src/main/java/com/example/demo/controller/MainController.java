package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@GetMapping("/joinpage")
	public String joinPage() {
		return "join";
	}

	@GetMapping("/LoginPage")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/logout")
	public String logoutPage() {
		session.invalidate();

		return "index";
	}

	@GetMapping("/freeboard")
	public String freeboard() {
		return "freeboard";
	}
}
