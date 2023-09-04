package com.github.paulovalleriote.dugeonexplorer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.github.paulovalleriote.dugeonexplorer.domain.models.user.User;

public interface UserRepository extends JpaRepository<User, String> {
  UserDetails findByLogin(String login);
}
