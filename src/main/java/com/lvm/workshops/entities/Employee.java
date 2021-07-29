package com.lvm.workshops.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String employeeName;
	private Double employeeTotalSales;
	private Double employeeBaseSalary;
	private Double employeeComission;
	
	public Employee() {	}

	public Employee(Long id, String employeeName, Double employeeTotalSales, Double employeeBaseSalary,
			Double employeeComission) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeTotalSales = employeeTotalSales;
		this.employeeBaseSalary = employeeBaseSalary;
		this.employeeComission = employeeComission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Double getEmployeeTotalSales() {
		return employeeTotalSales;
	}

	public void setEmployeeTotalSales(Double employeeTotalSales) {
		this.employeeTotalSales = employeeTotalSales;
	}

	public Double getEmployeeBaseSalary() {
		return employeeBaseSalary;
	}

	public void setEmployeeBaseSalary(Double employeeBaseSalary) {
		this.employeeBaseSalary = employeeBaseSalary;
	}

	public Double getEmployeeComission() {
		return employeeComission;
	}

	public void setEmployeeComission(Double employeeComission) {
		this.employeeComission = employeeComission;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
