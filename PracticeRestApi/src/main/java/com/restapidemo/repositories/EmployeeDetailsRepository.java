package com.restapidemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restapidemo.entities.EmployeeDetails;

@Repository
public interface EmployeeDetailsRepository extends CrudRepository<EmployeeDetails, Integer>{

}
