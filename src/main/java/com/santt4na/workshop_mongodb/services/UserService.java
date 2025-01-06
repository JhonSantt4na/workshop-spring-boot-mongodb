package com.santt4na.workshop_mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santt4na.workshop_mongodb.domain.User;
import com.santt4na.workshop_mongodb.repository.UserRepository;

@Service
public class UserService {

   @Autowired
   private UserRepository repository;

   public List<User> findAll() {
      return repository.findAll();
   }
}
