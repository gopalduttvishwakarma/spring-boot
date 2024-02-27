package com.restapidemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restapidemo.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
	public List<Employee> findByEmployeeGender(String employeeGender);
}
