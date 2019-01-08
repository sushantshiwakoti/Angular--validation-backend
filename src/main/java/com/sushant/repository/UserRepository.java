package com.sushant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sushant.model.User;

public interface UserRepository extends MongoRepository<User,String>{

	User findByEmail(String email);

}
