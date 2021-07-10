package com.ShoeSportt.ShoeSportt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoeSportt.ShoeSportt.entity.Category;
import com.ShoeSportt.ShoeSportt.entity.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repo;
	
	public List<Category> listAll(){
		return (List<Category>)repo.findAll();
		}
}

