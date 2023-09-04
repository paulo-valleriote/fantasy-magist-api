package com.github.paulovalleriote.dugeonexplorer.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.paulovalleriote.dugeonexplorer.domain.models.bag.Bag;
import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.Sheet;
import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.dtos.SheetCreationDTO;
import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.dtos.SheetDTO;
import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.dtos.SheetResponseDTO;
import com.github.paulovalleriote.dugeonexplorer.domain.models.user.User;
import com.github.paulovalleriote.dugeonexplorer.mapper.Mapper;
import com.github.paulovalleriote.dugeonexplorer.repositories.SheetRepository;
import com.github.paulovalleriote.dugeonexplorer.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SheetService {
  @Autowired
  private SheetRepository repository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BagService bagService;

  @Autowired
  private AttributesService attributesService;

  public List<SheetDTO> all(String userId) {
    return Mapper.parseObjectsList(repository.findByUserId(userId), SheetDTO.class);
  }

  public SheetResponseDTO byId(String id) throws EntityNotFoundException {
    return Mapper.parseObject(repository.findById(id).orElse(null), SheetResponseDTO.class);
  }

  public SheetDTO create(SheetCreationDTO sheetCreation) {
    Sheet newSheet = Mapper.parseObject(sheetCreation.getSheet(), Sheet.class);
    User storedUser = userRepository.findById(sheetCreation.getUserId()).orElse(null);

    if (storedUser == null)
      throw new EntityNotFoundException("User not found");
    else
      newSheet.setUser(storedUser);

    Sheet savedSheet = repository.save(newSheet);
    bagService.saveDefaultBag(savedSheet);
    attributesService.saveDefaultAttributes(savedSheet);

    return Mapper.parseObject(savedSheet, SheetDTO.class);
  }

  public Bag findBag(String id) {
    return this.bagService.find(id);
  }

  public void update(SheetDTO updateSheet, String id) {
    Sheet storedSheet = repository.findById(id).orElse(null);

    if (storedSheet == null)
      throw new EntityNotFoundException("Sheet not found");

    if (updateSheet.getName() != null)
      storedSheet.setName(updateSheet.getName());
    if (updateSheet.getCharacterClass() != null)
      storedSheet.setCharacterClass(updateSheet.getCharacterClass());
    if (updateSheet.getSpecie() != null)
      storedSheet.setSpecie(updateSheet.getSpecie());
    if (updateSheet.getLevel() > 0)
      storedSheet.setLevel(updateSheet.getLevel());

    repository.save(storedSheet);
  }

  public void delete(String id) {
    this.repository.deleteById(id);
  }

}
