package com.example.demo.service;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private UserPwHash userPwHash;

	public String joinUser(String userId, String userPw, String userName) {
		
		if(userId.equals("")||userPw.equals("")||userName.equals("")) {
			return "join";
		}
		
		Users user = new Users();
		user.setUserId(userId);
		String hashedPassword = userPwHash.getSHA256(userPw);
		user.setUserPw(hashedPassword);
		user.setUserName(userName);
		 
		userRepository.save(user);
		
		return "index";
	}
}
