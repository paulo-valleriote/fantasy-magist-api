package com.github.paulovalleriote.dugeonexplorer.http.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.dtos.SheetCreationDTO;
import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.dtos.SheetDTO;
import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.dtos.SheetResponseDTO;
import com.github.paulovalleriote.dugeonexplorer.services.SheetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sheets")
public class SheetController {
  @Autowired
  private SheetService sheetService;

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<SheetDTO>> findAll(@PathVariable("userId") String userId) {
    List<SheetDTO> sheets = this.sheetService.all(userId);
    return ResponseEntity.status(HttpStatus.OK).body(sheets);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<SheetResponseDTO> findOne(@PathVariable("userId") @Valid String id) {
    SheetResponseDTO sheet = this.sheetService.byId(id);
    return ResponseEntity.status(HttpStatus.OK).body(sheet);
  }

  @PostMapping("/{userId}")
  public ResponseEntity<SheetDTO> createSheet(@RequestBody @Valid SheetCreationDTO sheet) {
    SheetDTO createdSheet = this.sheetService.create(sheet);
    return ResponseEntity.status(HttpStatus.OK).body(createdSheet);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable("id") @Valid String id, @RequestBody SheetDTO sheet) {
    this.sheetService.update(sheet, id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") @Valid String id) {
    this.sheetService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
