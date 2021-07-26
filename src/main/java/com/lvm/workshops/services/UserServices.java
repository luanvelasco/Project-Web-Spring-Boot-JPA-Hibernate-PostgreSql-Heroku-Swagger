package com.lvm.workshops.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvm.workshops.entities.User;
import com.lvm.workshops.repositories.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository repository;
	
	
	public List<User> findAllUsers(){
		return repository.findAll();
	}
	
	public User findUserById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User addUser(User obj) {
		return repository.save(obj);
	}
	
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	public User updateUser(Long id, User obj){
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPassword(obj.getPassword());
		entity.setTelephone(obj.getTelephone());
		
	}
}
