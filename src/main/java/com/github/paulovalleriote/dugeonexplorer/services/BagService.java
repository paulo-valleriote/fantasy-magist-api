package com.github.paulovalleriote.dugeonexplorer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.paulovalleriote.dugeonexplorer.domain.models.bag.Bag;
import com.github.paulovalleriote.dugeonexplorer.domain.models.item.Item;
import com.github.paulovalleriote.dugeonexplorer.domain.models.item.dtos.ItemDTO;
import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.Sheet;
import com.github.paulovalleriote.dugeonexplorer.mapper.Mapper;
import com.github.paulovalleriote.dugeonexplorer.repositories.BagRepository;

@Service
public class BagService {
  @Autowired
  private BagRepository bagRepository;

  @Autowired
  private ItemService itemService;

  public Bag save(Bag bag) {
    return bagRepository.save(bag);
  }

  public Bag find(String bagId) {
    return bagRepository.findById(bagId).orElse(null);
  }

  public void saveDefaultBag(Sheet sheet) {
    Bag characterBag = new Bag();
    characterBag.setSheet(sheet);

    this.save(characterBag);
  }

  public ItemDTO addItemToBag(ItemDTO item, Bag bag) {
    return itemService.create(item, bag);
  }

  public void remoteItemFromBag(String itemId, Bag bag) {
    Item item = Mapper.parseObject(itemService.find(itemId), Item.class);
    bag.getItems().remove(item);

    itemService.delete(Mapper.parseObject(item, ItemDTO.class));
    this.save(bag);
  }
}
