package com.github.paulovalleriote.dugeonexplorer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.paulovalleriote.dugeonexplorer.domain.models.bag.Bag;

public interface BagRepository extends JpaRepository<Bag, String> {

}
