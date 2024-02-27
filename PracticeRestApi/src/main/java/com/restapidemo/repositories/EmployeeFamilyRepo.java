package com.restapidemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restapidemo.entities.EmployeeFamily;

@Repository
public interface EmployeeFamilyRepo extends CrudRepository<EmployeeFamily, Integer>{

}
