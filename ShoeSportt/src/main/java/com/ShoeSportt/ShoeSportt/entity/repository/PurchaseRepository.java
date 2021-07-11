package com.ShoeSportt.ShoeSportt.entity.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ShoeSportt.ShoeSportt.entity.PurchaseEntity;

@Repository
public interface PurchaseRepository extends CrudRepository<PurchaseEntity, Integer>{
	
//	@Query("select p from PurchaseEntity p where p.category.date = :DateTime")
//	List<PurchaseEntity> findAllByPublicationDate(@Param("date")Date d);
	List<PurchaseEntity> findBydate(Date date);
	//List<PurchaseEntity> findBydate();
	
	

}
