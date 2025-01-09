package com.santt4na.workshop_mongodb.services.exception;

public class ObjectNotFoundException extends RuntimeException{
   private  static final long serialVersion = 1L;

   public ObjectNotFoundException(String msg) {
      super(msg);
   }
}
