package com.ShoeSportt.ShoeSportt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ShoeSportt.ShoeSportt.entity.Category;
import com.ShoeSportt.ShoeSportt.entity.UserDetails;
import com.ShoeSportt.ShoeSportt.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@GetMapping("/activeUser")
	public String listAll(Model model) {
		List<UserDetails>list=userService.listAll();
	 	model.addAttribute("list",list);
	 	
	 	return "activeUser";
	}
}
