package com.github.paulovalleriote.dugeonexplorer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.paulovalleriote.dugeonexplorer.domain.models.bag.Bag;
import com.github.paulovalleriote.dugeonexplorer.domain.models.item.Item;
import com.github.paulovalleriote.dugeonexplorer.domain.models.item.dtos.ItemDTO;
import com.github.paulovalleriote.dugeonexplorer.mapper.Mapper;
import com.github.paulovalleriote.dugeonexplorer.repositories.ItemRepository;

@Service
public class ItemService {
  @Autowired
  private ItemRepository repository;

  public ItemDTO find(String id) {
    return Mapper.parseObject(repository.findById(id).orElse(null), ItemDTO.class);
  }

  public ItemDTO save(Item item) {
    return Mapper.parseObject(repository.save(item), ItemDTO.class);
  }

  public ItemDTO create(ItemDTO item, Bag bag) {
    Item newItem = Mapper.parseObject(item, Item.class);
    newItem.setBag(bag);

    return Mapper.parseObject(this.save(newItem), ItemDTO.class);
  }

  public void delete(ItemDTO item) {
    Item itemToDelete = Mapper.parseObject(item, Item.class);
    repository.delete(itemToDelete);
  }
}
