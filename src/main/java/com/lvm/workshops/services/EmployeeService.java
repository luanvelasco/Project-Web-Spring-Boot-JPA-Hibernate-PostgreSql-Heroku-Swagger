package com.lvm.workshops.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvm.workshops.entities.Employee;
import com.lvm.workshops.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> findAllEmployees(){
		return repository.findAll();
	}
	
	public Employee findEmployeeById(Long id) {
		Optional<Employee> obj = repository.findById(id);
		return obj.get();
	}
	
	public Employee addEmployee(Employee obj) {
		return repository.save(obj);
	}
	
	public void deleteEmployee(Long id) {
		repository.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	public Employee updateEmployee(Long id, Employee obj) {
		Employee entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Employee entity, Employee obj) {
		entity.setEmployeeBaseSalary(obj.getEmployeeBaseSalary());
		entity.setEmployeeComission(obj.getEmployeeComission());
		entity.setEmployeeName(obj.getEmployeeName());
	}
	
	public Double EmployeeTotalSalary(Long id) {
		Employee emp = repository.getById(id);
		return emp.getEmployeeTotalSales();
		
	}
}
