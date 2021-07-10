package com.ShoeSportt.ShoeSportt.entity.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ShoeSportt.ShoeSportt.entity.UserDetails;


@Repository
public interface UserRepository extends CrudRepository<UserDetails, Integer> {

	@Query("Select a from UserDetails a where a.enabled=1 ")
	public List<UserDetails> findactiveUser();
	

}