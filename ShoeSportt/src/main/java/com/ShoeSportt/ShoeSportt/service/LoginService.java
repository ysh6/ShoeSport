package com.ShoeSportt.ShoeSportt.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean validateLogin(String userid, String password) {
		return userid.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("password");	
	}

}
