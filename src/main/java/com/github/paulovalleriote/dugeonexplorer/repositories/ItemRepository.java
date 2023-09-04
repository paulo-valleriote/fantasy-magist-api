package com.github.paulovalleriote.dugeonexplorer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.paulovalleriote.dugeonexplorer.domain.models.item.Item;

public interface ItemRepository extends JpaRepository<Item, String> {

}
