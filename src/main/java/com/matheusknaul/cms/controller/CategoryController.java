package com.matheusknaul.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusknaul.cms.domain.Category;
import com.matheusknaul.cms.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> listAll(){
		return ResponseEntity.ok(categoryService.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> searchById(@PathVariable Integer id){
		return ResponseEntity.ok(categoryService.searchById(id));
	}
	
	@PostMapping
	public ResponseEntity<Category> save(@RequestBody Category category){
		return ResponseEntity.ok(categoryService.save(category));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> update(@PathVariable Integer id, @RequestBody Category category){
		Category categoryEdited = categoryService.update(id, category);
		return ResponseEntity.ok(categoryService.save(categoryEdited));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Category> save(@PathVariable Integer id){
		categoryService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
