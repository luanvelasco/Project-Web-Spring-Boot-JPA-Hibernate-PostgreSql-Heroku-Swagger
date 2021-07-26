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

import com.lvm.workshops.entities.User;
import com.lvm.workshops.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	private UserServices service;
	
	
	@GetMapping
	public ResponseEntity<List<User>> findAllUsers(){
		List<User> list = service.findAllUsers();
		return ResponseEntity
				.ok()
				.body(list);	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findUserById(@PathVariable Long id){
		User obj = service.findUserById(id);
		return ResponseEntity
				.ok()
				.body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User obj){
		obj = service.addUser(obj);
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
	public ResponseEntity<Void> deleteUser(@PathVariable Long id){
		service.deleteUser(id);
		return ResponseEntity
				.noContent()
				.build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> updateUser (@PathVariable Long id, @RequestBody User obj){
		obj = service.updateUser(id, obj);
		return ResponseEntity
				.ok()
				.body(obj);
	}
}
