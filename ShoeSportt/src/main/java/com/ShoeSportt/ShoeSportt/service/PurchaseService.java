package com.ShoeSportt.ShoeSportt.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoeSportt.ShoeSportt.entity.PurchaseEntity;
import com.ShoeSportt.ShoeSportt.entity.UserDetails;
import com.ShoeSportt.ShoeSportt.entity.repository.PurchaseRepository;

@Service
public class PurchaseService {
	@Autowired
	PurchaseRepository repo;
	public List<PurchaseEntity> listAll(Date d){
		return (List<PurchaseEntity>)repo.findBydate(d);
		}
	
	
}
