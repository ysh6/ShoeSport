package com.ShoeSportt.ShoeSportt.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ShoeSportt.ShoeSportt.entity.PurchaseEntity;
import com.ShoeSportt.ShoeSportt.service.PurchaseService;


@Controller
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseservice;
	@GetMapping("/purchasereport")
	public String listAll(Model model) {
		Date d=new Date(2021-07-11);
		//List<PurchaseEntity>list=purchaseservice.listAll(d);
		List<PurchaseEntity>list=purchaseservice.listAll(d);
	 	model.addAttribute("list",list);
	 	
	 	return "purchasereport";
	 	
	}
	
	@GetMapping("/purchasereport1")
	public String listPurchaseAll(Model model,@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date d) {
	//	Date d=new Date(2021-07-11);
		//List<PurchaseEntity>list=purchaseservice.listAll(d);
		List<PurchaseEntity>list=purchaseservice.listAll(d);
	 	model.addAttribute("list",list);
	 	
	 	return "purchasereport";
	 	
	}
	
	
}
