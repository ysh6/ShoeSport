package com.ShoeSportt.ShoeSportt.entity.repository;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ShoeSportt.ShoeSportt.entity.Category;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository repo;

	
	@Test
	public void testCategoryRootRepostiory()
	{
		Category category=new Category("SportShoe");
		Category saveCategory=repo.save(category);
		
	
	}
}
