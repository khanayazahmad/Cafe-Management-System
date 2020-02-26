package com.cmpe202.starbucks.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPermissionRepository extends JpaRepository<Permission, Long> {
    List<Permission> findByUsername(String username);
}
