package com.restapidemo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_details")
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_det_id")
	private int employeeDetId;
	private String employeeAddress;
	private String employeeStatus;
	private String employeeBg;
	
	@OneToOne
	@JsonBackReference
	@JoinColumn(name="employee_p_id")
	private Employee employee;

	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDetails(int employeeDetId, String employeeAddress, String employeeStatus, String employeeBg, Employee employee) {
		super();
		this.employeeDetId = employeeDetId;
		this.employeeAddress = employeeAddress;
		this.employeeStatus = employeeStatus;
		this.employeeBg = employeeBg;
		this.employee = employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getEmployeeDetId() {
		return employeeDetId;
	}

	public void setEmployeeDetId(int employeeDetId) {
		this.employeeDetId = employeeDetId;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getEmployeeBg() {
		return employeeBg;
	}

	public void setEmployeeBg(String employeeBg) {
		this.employeeBg = employeeBg;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employeeDetId=" + employeeDetId + ", employeeAddress=" + employeeAddress
				+ ", employeeStatus=" + employeeStatus + ", employeeBg=" + employeeBg + "]";
	}
}
