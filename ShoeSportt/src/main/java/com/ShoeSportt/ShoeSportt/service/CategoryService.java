package com.ShoeSportt.ShoeSportt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoeSportt.ShoeSportt.entity.Category;
import com.ShoeSportt.ShoeSportt.entity.repository.CategoryRepository;

import net.bytebuddy.pool.TypePool.AbstractBase.Hierarchical;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repo;
	
	public List<Category> listAll(){
		List<Category> rootCategories =repo.findRootCategories();	
		
		return  listHeirarchicalCategory(rootCategories);
	}
	
	public List<Category> findRootCategories(){
	//	return (List<Category>)repo.findAll();
	List<Category> rootCategories =repo.findRootCategories();	
	return listHeirarchicalCategory(rootCategories);
	}
	
	
	public List<Category> listCategoriesUsedInFrom(){
		List<Category> categoriesUsedInForm =new ArrayList<>();
		
		Iterable<Category> categoriesInDB= repo.findAll();
		
		for(Category category: categoriesInDB) {
			if(category.getParent()==null) {
			categoriesUsedInForm.add(new Category(category.getName()));
				
				Set<Category> children = category.getChildren();
				
				for(Category subCategory:children)
				{
					String name="--"+ subCategory.getName();
					categoriesUsedInForm.add(new Category(name));
					listChildren(categoriesUsedInForm,subCategory,1);
					
				}
			}
		}
		
		
		
		return categoriesUsedInForm; 
		
	}
	
	
	
	
	private void listChildren(List<Category> categoriesUsedInForm ,Category parent, int subLevel){
		int newSubLevel =subLevel+1;
		Set<Category> children = parent.getChildren();
		
		for(Category subCategory: children) {
			String name ="";
			for (int i = 0; i < newSubLevel; i++) {
				name+="--";
			}
			categoriesUsedInForm.add(new Category(name));
			listChildren(categoriesUsedInForm,subCategory, newSubLevel);
			
		}
		
		
	}
	
	
	
	public List<Category> listRootCategory(){
		return (List<Category>)repo.listRootCategories();
		}
	
	
	private List<Category> listHeirarchicalCategory(List<Category> rootCategories ){
		List<Category> heirarchicalCategories= new ArrayList<>();
		
		for(Category rootCategory: rootCategories)
		{
			heirarchicalCategories.add(Category.copyFull(rootCategory));
	Set <Category> children =rootCategory.getChildren();
	for(Category subCategory:children)
		{
			String name ="--"+ subCategory.getName();
			heirarchicalCategories.add(Category.copyFull(rootCategory,name));
			
			listSubHierarchicalCategories(heirarchicalCategories,subCategory, 1);
		
		}
		
		}
		
		return heirarchicalCategories;
	}
	
	
	private void listSubHierarchicalCategories(List<Category> hierarchicalCategories,Category parent,int subLevel) {
		
		Set<Category> childern =parent.getChildren();
		int  newSubLevel = subLevel+1;
		
		for(Category subCategory : childern) {
			String name="";
			for (int i = 0; i < newSubLevel; i++) {
				name+="--";
			}
			
			name +=subCategory.getName();
			hierarchicalCategories.add(Category.copyFull(subCategory, name));
			
			listSubHierarchicalCategories(hierarchicalCategories, subCategory, newSubLevel);
			
		}
	}
	
private void listSubCategoriesUsedInForm (List<Category> categoriesUsedInForm, Category parent, int subLevel){
	
	int newSubLevel=subLevel+1;
	Set<Category> children= parent.getChildren();
	
	for(Category subCategory :children)
	{
		String name="";
		for (int i = 0; i < newSubLevel; i++) {
			name+="--";
		}
		name +=subCategory.getName();
		categoriesUsedInForm.add(Category.copyIdAndName(subCategory.getId(),name));
		listSubCategoriesUsedInForm(categoriesUsedInForm,subCategory,newSubLevel);
	}
	
}
	
	
	
	
		
	}
	
	
	
	



