package com.lvm.workshops.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lvm.workshops.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
