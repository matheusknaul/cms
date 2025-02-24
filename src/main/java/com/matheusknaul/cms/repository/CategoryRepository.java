package com.matheusknaul.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusknaul.cms.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
