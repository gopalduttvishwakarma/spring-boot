package com.restapidemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapidemo.entities.Employee;
import com.restapidemo.entities.EmployeeDetails;
import com.restapidemo.entities.EmployeeFamily;
import com.restapidemo.repositories.EmployeeDetailsRepository;
import com.restapidemo.repositories.EmployeeFamilyRepo;
import com.restapidemo.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeDetailsRepository detailsRepository;
	
	@Autowired
	private EmployeeFamilyRepo employeeFamilyRepo;

	public Iterable<Employee> fetchAllEmployees() {
		Iterable<Employee> allEmp = this.employeeRepository.findAll();
		return allEmp;
	}

	public Employee addEmployee(Employee employee) {
		EmployeeDetails emp = employee.getEmpDetails();
		Employee result = this.employeeRepository.save(employee);
		if (result != null && employee.getEmpDetails() != null) {
			emp.setEmployee(result);
			addEmpDetails(emp);
		}
		return result;
	}

	public Optional<Employee> fetchEmployeebyId(int employeeId) {
		Optional<Employee> emp = this.employeeRepository.findById(employeeId);
		return emp;
	}

	public Employee updateEmployee(Employee employee) {
		Employee result = this.employeeRepository.save(employee);
		return result;
	}

	public String deleteEmployee(int employeeId) {
		this.employeeRepository.deleteById(employeeId);
		return "Deleted!";
	}

	public List<Employee> fetchEmployeeByGender(String employeeGender) {
		List<Employee> emp = this.employeeRepository.findByEmployeeGender(employeeGender);
		return emp;
	}

	public EmployeeDetails addEmpDetails(EmployeeDetails empDetails) {
		EmployeeDetails emp = this.detailsRepository.save(empDetails);
		return emp;
	}
	
	public EmployeeFamily addEmployeeFamily(EmployeeFamily empF) {
		EmployeeFamily emp = this.employeeFamilyRepo.save(empF);
		return emp;
	}
}
