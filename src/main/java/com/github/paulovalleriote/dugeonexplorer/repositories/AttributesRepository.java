package com.github.paulovalleriote.dugeonexplorer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.paulovalleriote.dugeonexplorer.domain.models.attributes.Attributes;

public interface AttributesRepository extends JpaRepository<Attributes, String> {

}
