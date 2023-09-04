package com.github.paulovalleriote.dugeonexplorer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.paulovalleriote.dugeonexplorer.domain.models.attributes.Attributes;
import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.Sheet;
import com.github.paulovalleriote.dugeonexplorer.repositories.AttributesRepository;

@Service
public class AttributesService {
  @Autowired
  private AttributesRepository repository;

  public Attributes save(Attributes attributes) {
    return repository.save(attributes);
  }

  public void saveDefaultAttributes(Sheet sheet) {
    Attributes attributes = new Attributes();
    attributes.setSheet(sheet);

    this.save(attributes);
  }

}
