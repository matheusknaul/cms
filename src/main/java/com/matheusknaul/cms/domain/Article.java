package com.matheusknaul.cms.domain;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Article {

	@Id
	private Integer id;
	
	private String title;
	private String content;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Author author;

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(Integer id, String title, Category category, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.author = author;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAutor(Author author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
