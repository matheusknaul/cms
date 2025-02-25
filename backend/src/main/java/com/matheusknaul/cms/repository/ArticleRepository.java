package com.matheusknaul.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusknaul.cms.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

}
