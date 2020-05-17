package com.sistema.de.consulatas.services;

import com.sistema.de.consulatas.model.Employee;
import com.sistema.de.consulatas.repository.EmployeeRepository;
import com.sistema.de.consulatas.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired()
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	@Autowired
//	public EmployeeService(EmployeeRepository employeeRepository,
//						   @Qualifier("roleRepository") RoleRepository roleRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
//
//		this.employeeRepository = employeeRepository;
//		this.roleRepository = roleRepository;
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//	}
	
	public Employee findUserByUsername(String username) {
		return employeeRepository.findByUsername(username);
	}
	
	public void saveEmployeeService(Employee e) {
		if(e.getId() != null) {
			Employee emp = employeeRepository.findById(e.getId()).get();
			emp.setName(e.getName());
			emp.setPassword(bCryptPasswordEncoder.encode(e.getPassword()));
			emp.setUsername(e.getUsername());
			employeeRepository.save(emp);
		}
		else {
			e.setPassword(bCryptPasswordEncoder.encode(e.getPassword()));
			employeeRepository.save(e);
		}
		
	}
	
	public List<Employee> getAllEmployee(){
		return employeeRepository.findByIsDeletedFalse();
	}
	
	public void deleteEmployee(Long userId) {
		Employee e = getEmployee(userId);
		if(e!=null) {
			e.setIsDeleted(Boolean.TRUE);
			employeeRepository.save(e);
		}
	}
	
	public Employee getEmployee(Long userId) {
		return employeeRepository.findById(userId).orElse(null);
	}
}
