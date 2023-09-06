package com.github.paulovalleriote.dugeonexplorer.http.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.paulovalleriote.dugeonexplorer.domain.models.bag.Bag;
import com.github.paulovalleriote.dugeonexplorer.domain.models.item.dtos.ItemDTO;
import com.github.paulovalleriote.dugeonexplorer.services.BagService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
  @Autowired
  private BagService bagService;

  @PostMapping("/bag/item")
  public ResponseEntity<ItemDTO> addItemToBag(@RequestBody ItemDTO item, @RequestBody String bagId) {
    Bag characterBag = bagService.find(bagId);
    ItemDTO newItem = bagService.addItemToBag(item, characterBag);
    return ResponseEntity.status(HttpStatus.OK).body(newItem);
  }

  @DeleteMapping("/bag/item")
  public ResponseEntity<Void> removeItemFromBag(@RequestParam String itemId, @RequestBody String bagId) {
    Bag characterBag = bagService.find(bagId);
    bagService.remoteItemFromBag(itemId, characterBag);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
