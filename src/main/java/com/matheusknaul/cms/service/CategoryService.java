package com.matheusknaul.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusknaul.cms.domain.Category;
import com.matheusknaul.cms.repository.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> listAll(){
		return categoryRepository.findAll();
	}
	
	public Category searchById(Integer id) {
		return categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found!"));
	}
	
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category update(Integer id, Category category) {
		Category categoryExistent = searchById(id);
		categoryExistent.setDescription(category.getDescription());
		categoryExistent.setTitle(category.getTitle());
		return categoryRepository.save(categoryExistent);
	}
	
	public void delete(Integer id) {
		categoryRepository.deleteById(id);
	}
	
}
