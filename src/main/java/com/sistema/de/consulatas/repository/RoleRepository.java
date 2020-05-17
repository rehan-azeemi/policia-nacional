package com.sistema.de.consulatas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.sistema.de.consulatas.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByRole(String role);
}
