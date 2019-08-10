package com.example.demo.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class LoginService {
	
	@Autowired
	private UserPwHash userPwHash;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	HttpSession session;
	

	public String login(String userId, String userPw) {
		
		if(userId.equals("")||userPw.equals("")) {
			 return "login";
		}
		
		String hashedPassword = userPwHash.getSHA256(userPw);
		Users user = usersRepository.findByUserIdAndUserPw(userId, hashedPassword);
		
		if(user==null) {
			return "login";
		}
		
		session.setAttribute("loginUser", user);
		
		
		
		return "index";
	}

}
