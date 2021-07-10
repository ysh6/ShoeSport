package com.ShoeSportt.ShoeSportt.entity.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ShoeSportt.ShoeSportt.entity.UserDetails;

@Repository
public interface UserRepository extends CrudRepository<UserDetails, Integer> {

}