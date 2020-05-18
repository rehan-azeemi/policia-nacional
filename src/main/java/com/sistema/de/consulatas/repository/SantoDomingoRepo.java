package com.sistema.de.consulatas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sistema.de.consulatas.model.SantoDomingo;
import java.util.List;

@Repository
public interface SantoDomingoRepo extends JpaRepository<SantoDomingo, Long>{

    List<SantoDomingo> findAllByIsDeletedFalse();
    SantoDomingo findByIdAndIsDeletedFalse(Long id);
    @Query(value="SELECT * FROM santo_domingo WHERE STR_TO_DATE(fecha,'%m-%d-%Y') >= STR_TO_DATE(:from,'%m-%d-%Y') AND STR_TO_DATE(fecha,'%m-%d-%Y') <= STR_TO_DATE(:to,'%m-%d-%Y')",nativeQuery=true)
	public List<SantoDomingo> findAll(@Param("from") String from,@Param("to") String to); 
}
