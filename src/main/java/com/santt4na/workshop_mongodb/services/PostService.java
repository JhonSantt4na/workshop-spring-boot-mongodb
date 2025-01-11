package com.santt4na.workshop_mongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santt4na.workshop_mongodb.domain.Post;
import com.santt4na.workshop_mongodb.repository.PostRepository;
import com.santt4na.workshop_mongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

   @Autowired
   private PostRepository repo;

   public Post findById(String id) {
      Optional<Post> obj = repo.findById(id);
      return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
   }

}