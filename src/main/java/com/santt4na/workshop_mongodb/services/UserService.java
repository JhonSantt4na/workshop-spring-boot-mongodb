package com.santt4na.workshop_mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santt4na.workshop_mongodb.domain.User;
import com.santt4na.workshop_mongodb.dto.UserDTO;
import com.santt4na.workshop_mongodb.repository.UserRepository;
import com.santt4na.workshop_mongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

   @Autowired
   private UserRepository repository;

   public List<User> findAll() {
      return repository.findAll();
   }

   public User findById(String id) {
      Optional<User> obj = repository.findById(id);
      return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
   }

   public User insert(User obj) {
      return repository.insert(obj);
   }

   public void delete(String id) {
      findById(id);
      repository.deleteById(id);
   }

   public User update(User obj) {
      User newObj = findById(obj.getId());
      updateData(newObj, obj);
      return repository.save(newObj);
   }

   private void updateData(User newObj, User obj) {
      newObj.setName(obj.getName());
      newObj.setEmail(obj.getEmail());
   }

   public User fromDTO(UserDTO objDTO) {
      return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
   }

}
