package com.lvm.workshops.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvm.workshops.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		//Test the method
		User user = new User(1L, "Luan Velasco", "luanvelasco@gmail.com", "9999999", "sd5425");
		return ResponseEntity.ok().body(user);	
	}
	
	
}
