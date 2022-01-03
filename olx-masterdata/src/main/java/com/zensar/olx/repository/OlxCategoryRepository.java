package com.zensar.olx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olx.model.Categories;

public interface OlxCategoryRepository extends JpaRepository<Categories, Integer> {

}
