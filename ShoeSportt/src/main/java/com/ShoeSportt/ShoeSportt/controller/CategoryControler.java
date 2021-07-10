package com.ShoeSportt.ShoeSportt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ShoeSportt.ShoeSportt.entity.Category;
import com.ShoeSportt.ShoeSportt.service.CategoryService;



@Controller
public class CategoryControler {

	@Autowired
	private CategoryService service;
	
	@GetMapping("/categories")
	public String listAll(Model model) {
		List<Category>listCategories=	service.findRootCategories();
	 	model.addAttribute("listCategories",listCategories);
	 	
	 	return "categories";
	
	}
	
	@GetMapping("/categories/new")
	public String newCategory(Model model) {
		List<Category>listCategories=	service.listRootCategory();
	 	model.addAttribute("category",new Category());
	 	
	 	return "category_form";
	
	}
	
}
