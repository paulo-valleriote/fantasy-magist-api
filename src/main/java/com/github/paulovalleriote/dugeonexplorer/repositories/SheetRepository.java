package com.github.paulovalleriote.dugeonexplorer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.Sheet;

public interface SheetRepository extends JpaRepository<Sheet, String> {
  @Query("SELECT s FROM Sheet s WHERE s.user.id = ?1")
  public List<Sheet> findByUserId(String userId);
}
