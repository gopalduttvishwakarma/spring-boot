package com.restapidemo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapidemo.entities.Employee;
import com.restapidemo.entities.EmployeeDetails;
import com.restapidemo.entities.EmployeeFamily;
import com.restapidemo.services.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("testEmp")	
	public String testEmp() {
		return "Hi I am Employee Controller";
	}
	
	@GetMapping("/employee")
	public Iterable<Employee> getAllEmployees() {
		Iterable<Employee> allEmp = this.employeeService.fetchAllEmployees();
		return allEmp;
	}
	
	@GetMapping("/employee/{employeeId}")
	public Optional<Employee> getEmployeeById(@PathVariable("employeeId") int employeeId) {
		Optional<Employee> emp = this.employeeService.fetchEmployeebyId(employeeId);
		return emp;
	}
	
	@GetMapping("/employeeByGender/{employeeGender}")
	public List<Employee> getEmployeeById(@PathVariable("employeeGender") String employeeGender) {
		List<Employee> emp = this.employeeService.fetchEmployeeByGender(employeeGender);
		return emp;
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		Employee emp = this.employeeService.addEmployee(employee);
		return emp;
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee emp = this.employeeService.addEmployee(employee);
		return emp;
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") int employeeId) {
		String r = this.employeeService.deleteEmployee(employeeId);
		return r; 
	}
	
	@PostMapping("/empDetails")
    public EmployeeDetails addEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
		EmployeeDetails emp = this.employeeService.addEmpDetails(employeeDetails);
		return emp;
	}
	
	@PostMapping("/empFamily")
    public EmployeeFamily addEmployeeFamily(@RequestBody EmployeeFamily e) {
		EmployeeFamily emp = this.employeeService.addEmployeeFamily(e);
		return emp;
	}
}
