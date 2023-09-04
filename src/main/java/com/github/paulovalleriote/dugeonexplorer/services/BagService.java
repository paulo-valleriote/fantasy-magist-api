package com.github.paulovalleriote.dugeonexplorer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.paulovalleriote.dugeonexplorer.domain.models.bag.Bag;
import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.Sheet;
import com.github.paulovalleriote.dugeonexplorer.repositories.BagRepository;

@Service
public class BagService {
  @Autowired
  private BagRepository bagRepository;

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
}
