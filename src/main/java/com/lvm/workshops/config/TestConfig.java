// -----------------------------------------------------------
// * Data: 22/07/2021                                        *
// * Versão: 001                                             *
// * Classe de configuração para instanciar o banco de dados *
// -----------------------------------------------------------
package com.lvm.workshops.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lvm.workshops.entities.Employee;
import com.lvm.workshops.entities.User;
import com.lvm.workshops.repositories.EmployeeRepository;
import com.lvm.workshops.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private  UserRepository userRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Employee emp1 = new Employee(null, "Josh Mb", 550.50, 2000.0, 0.25, null);
		Employee emp2 = new Employee(null, "Robert Dj", 600.0, 3000.0, 0.15, null);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		employeeRepository.saveAll(Arrays.asList(emp1, emp2));
	}
	
}
