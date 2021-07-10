package com.ShoeSportt.ShoeSportt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoeSportt.ShoeSportt.entity.Category;
import com.ShoeSportt.ShoeSportt.entity.UserDetails;
import com.ShoeSportt.ShoeSportt.entity.repository.CategoryRepository;
import com.ShoeSportt.ShoeSportt.entity.repository.UserRepository;

@Service
public class UserService {
	
    @Autowired
	private UserRepository usrrepo;
	
	public List<UserDetails> listAll(){
		return (List<UserDetails>)usrrepo.findAll();
		}

}
