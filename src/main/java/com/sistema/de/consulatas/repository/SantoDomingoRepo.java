package com.sistema.de.consulatas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.de.consulatas.model.SantoDomingo;

@Repository
public interface SantoDomingoRepo extends JpaRepository<SantoDomingo, Long>{

}
