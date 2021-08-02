package com.lvm.workshops.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lvm.workshops.entities.Employee;
import com.lvm.workshops.services.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> findAllEmployees(){
		List<Employee> list = employeeService.findAllEmployees();
		return ResponseEntity
				.ok()
				.body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id){
		Employee obj = employeeService.findEmployeeById(id);
		return ResponseEntity
				.ok()
				.body(obj);
	}
	
	public ResponseEntity<Double> employeeTotalSalary(@PathVariable Long id){
		Double salary = employeeService.EmployeeTotalSalary(id);
		return ResponseEntity
				.ok()
				.body(salary);		
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee obj){
		obj = employeeService.addEmployee(obj);
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(obj.getId())
					.toUri();
		
		return ResponseEntity
				.created(uri)
				.body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
		employeeService.deleteEmployee(id);
		return ResponseEntity
				.noContent()
				.build();
	}
	
		@PutMapping(value = "/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee obj){
		obj = employeeService.updateEmployee(id, obj);
		return ResponseEntity
				.ok()
				.body(obj);
	}
}
