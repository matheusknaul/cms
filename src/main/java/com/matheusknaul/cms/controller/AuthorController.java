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

import com.matheusknaul.cms.domain.Author;
import com.matheusknaul.cms.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@GetMapping
	public ResponseEntity<List<Author>> listAll(){
		return ResponseEntity.ok(authorService.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Author> searchById(@PathVariable Integer id){
		return ResponseEntity.ok(authorService.searchById(id));
	}
	
	@PostMapping
	public ResponseEntity<Author> save(@RequestBody Author author){
		return ResponseEntity.ok(authorService.save(author));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Author> update(@PathVariable Integer id, @RequestBody Author author){
		Author authorEdited = authorService.update(id, author);
		return ResponseEntity.ok(authorService.save(authorEdited));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Author> save(@PathVariable Integer id){
		authorService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
