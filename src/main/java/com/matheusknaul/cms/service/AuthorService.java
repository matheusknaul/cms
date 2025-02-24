package com.matheusknaul.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matheusknaul.cms.domain.Author;
import com.matheusknaul.cms.repository.AuthorRepository;

@Service
public class AuthorService {

	private final AuthorRepository authorRepository;
	
	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	public List<Author> listAll(){
		return authorRepository.findAll();
	}
	
	public Author searchById(Integer id) {
		return authorRepository.findById(id).orElseThrow(()-> new RuntimeException("Author dont exists!"));
	}
	
	public Author save(Author author) {
		return authorRepository.save(author);
	}
	
	public Author update(Integer id, Author author) {
		Author authorExistent = searchById(id);
		
		authorExistent.setName(author.getName());
		authorExistent.setEmail(author.getEmail());
		authorExistent.setPassword(author.getPassword());
		return authorRepository.save(authorExistent);
	}
	
	public void delete(Integer id) {
		authorRepository.deleteById(id);
	
}
}