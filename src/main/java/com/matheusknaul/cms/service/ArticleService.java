package com.matheusknaul.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matheusknaul.cms.domain.Article;
import com.matheusknaul.cms.repository.ArticleRepository;

@Service
public class ArticleService {
	
	private final ArticleRepository articleRepository;
	
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	
	public List<Article> listAll(){
		return articleRepository.findAll();
	}
	
	public Article searchById(Integer id) {
		return articleRepository.findById(id).
				orElseThrow(()-> new RuntimeException("Article dont found"));
	}
	
	public Article save(Article article) {
		return articleRepository.save(article);
	}
	
	public Article update(Integer id, Article article) {
		Article articleExistent = searchById(id);
		articleExistent.setTitle(article.getTitle());
		articleExistent.setContent(article.getContent());
		articleExistent.setCategory(article.getCategory());
		return save(articleExistent);
	}
	
	public void delete(Integer id) {
		articleRepository.deleteById(id);
	}
}
