package com.lvm.workshops.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lvm.workshops.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
