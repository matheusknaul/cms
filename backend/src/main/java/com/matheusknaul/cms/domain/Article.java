package com.matheusknaul.cms.domain;

import java.util.Objects;

import com.matheusknaul.cms.domain.enums.Status;

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
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	private Status status;
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(Integer id, Status status, String title, Category category, Author author) {
		super();
		this.id = id;
		this.status = status;
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
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setAuthor(Author author) {
		this.author = author;
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
