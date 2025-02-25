package com.matheusknaul.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusknaul.cms.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
