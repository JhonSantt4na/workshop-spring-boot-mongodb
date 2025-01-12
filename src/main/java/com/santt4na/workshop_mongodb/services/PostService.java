package com.santt4na.workshop_mongodb.services;

import java.util.Calendar;
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

   public List<Post> findByTitle(String text) {
      return repo.searchTitle(text);
   }

   public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
      maxDate = new Date(maxDate.getTime() + 86399999);
      return repo.fullSearch(text, minDate, maxDate);
   }
}