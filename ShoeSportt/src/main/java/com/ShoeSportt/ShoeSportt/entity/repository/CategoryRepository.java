package com.ShoeSportt.ShoeSportt.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ShoeSportt.ShoeSportt.entity.Category;
@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
	
	
	@Query("Select c from Category c where c.parent.id is NULL")
	public List<Category> listRootCategories();
	
	@Query("Select c from Category c where c.parent.id is NULL")
	public List<Category> findRootCategories();

}
