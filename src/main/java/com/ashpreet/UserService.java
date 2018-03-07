package com.ashpreet;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	 @Autowired  
	    private UserRepository userRepository;  
	    public List<User> getAllUsers(){  
	    	
	        List<User> userRecords = new ArrayList<>();  
	        Iterable<User> iterable=userRepository.findAll();
	        if(iterable != null) {
	            for(User u: iterable) {
	              userRecords.add(u);
	            }
	          }
	        return userRecords;  
	    }  
	    
	   
		public User getUser(String id){
			System.out.println("Entered getuser");
	        return (User)userRepository.findOne(id);  
	    }  
	    
	    public void addUser(User user){  
	    	System.out.println("Entered addUser");
	        userRepository.save(user); 
	    }  
	    public void delete(String id){  
	        userRepository.delete(id);  
	    }  

	    
}
