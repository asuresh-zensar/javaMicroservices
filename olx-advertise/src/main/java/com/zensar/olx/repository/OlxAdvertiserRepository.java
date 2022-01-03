package com.zensar.olx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olx.model.Advertises;

public interface OlxAdvertiserRepository extends JpaRepository<Advertises, Integer>{

}
