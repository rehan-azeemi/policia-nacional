package com.sistema.de.consulatas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sistema.de.consulatas.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	public List<Employee> findByIsDeletedFalse();
	public Employee findByUsername(String username);
}
