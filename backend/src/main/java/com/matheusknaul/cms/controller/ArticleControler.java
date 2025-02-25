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

import com.matheusknaul.cms.domain.Article;
import com.matheusknaul.cms.service.ArticleService;

@RestController
@RequestMapping("/api/articles")
public class ArticleControler {
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping
	public ResponseEntity<List<Article>> listAll(){
		return ResponseEntity.ok(articleService.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Article> searchById(@PathVariable Integer id){
		return ResponseEntity.ok(articleService.searchById(id));
	}
	
	@PostMapping
	public ResponseEntity<Article> save(@RequestBody Article article){
		Article newArticle = articleService.save(article);
		return ResponseEntity.ok(newArticle);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Article> update(@PathVariable Integer id,@RequestBody Article article){
		Article articleEdited = articleService.update(id, article);
		return ResponseEntity.ok(articleEdited);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		articleService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
