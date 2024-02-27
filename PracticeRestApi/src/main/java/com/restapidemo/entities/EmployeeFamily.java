package com.restapidemo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_family")
public class EmployeeFamily {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeFamilyId; 
	private String relation;
	private String memberName;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	@JsonBackReference
	private Employee employee;
	
	public int getEmployeeFamilyId() {
		return employeeFamilyId;
	}
	public void setEmployeeFamilyId(int employeeFamilyId) {
		this.employeeFamilyId = employeeFamilyId;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
