package com.practice.microservice.userservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.microservice.userservice.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}