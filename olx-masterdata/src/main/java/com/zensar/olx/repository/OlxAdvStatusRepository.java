package com.zensar.olx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olx.model.AdvStatus;

public interface OlxAdvStatusRepository extends JpaRepository<AdvStatus, Integer> {

}
