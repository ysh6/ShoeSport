package com.ShoeSportt.ShoeSportt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ShoeSportt.ShoeSportt.entity.EProduct;
import com.ShoeSportt.ShoeSportt.entity.UserDetails;
import com.ShoeSportt.ShoeSportt.entity.repository.EProductDAO;
import com.ShoeSportt.ShoeSportt.entity.repository.UserRepository;
import com.ShoeSportt.ShoeSportt.service.LoginService;
import com.ShoeSportt.ShoeSportt.service.UserService;

@Controller

public class LoginController {
	
	@Autowired
	LoginService service;
	
	@Autowired
	UserService logindetails;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage(ModelMap model)
	{
		return "login";
	}
	
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String showDashboard(ModelMap model)
	{
		return "dashboard";
	}
	
	
//	@RequestMapping(value="/activeUser", method=RequestMethod.GET)
//	public List<UserDetails> showActiveUsers(ModelMap model)
//	{
//		
//	return logindetails.getActiveUserDetails();	
//	}
	
	
	
	
	
//	@RequestMapping(value = "/activeUser1", method = RequestMethod.GET)
//	public String listActiveUser(ModelMap map) {
//		List<UserDetails> list = logindetails.getActiveUserDetails();
//		map.addAttribute("list", list);
//		return "activeUser";
//	}
	
	
	@Autowired
	UserRepository activeUser;

//	@RequestMapping(value = "/activeUser", method = RequestMethod.GET)
//	public String listProducts1(Model map) {
//		List<UserDetails> list = activeUser.showAllUsers();
//		map.addAttribute("list", list);
//		return "activeUser";
//	}
	
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String ValidatedPage(ModelMap model, @RequestParam("name") String name, @RequestParam("password") String password)
	{
	
		boolean isValidUser= service.validateLogin(name, password);
		if(!isValidUser)
		{
			model.put("errorMessage", "Invalid Username or Password");
			return "login";
		}
		model.put("name",name);
		model.put("password", password);
		return "dashboard";
		
	}
	
	
	
	
	
	@Autowired
	EProductDAO eproductDAO;

	@RequestMapping(value = "/listProducts", method = RequestMethod.GET)
	public String listProducts(Model map) {
		List<EProduct> list = eproductDAO.getProducts();
		map.addAttribute("list", list);
		return "listProducts";
	}

	
	
	
}
