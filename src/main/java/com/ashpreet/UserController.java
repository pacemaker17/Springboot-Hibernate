package com.ashpreet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;



@RestController
public class UserController {
		
		
		
	 	@Autowired  
	    private UserService userService;   
	    @RequestMapping("/")  
	    public List<User> getAllUser(){  
	        return userService.getAllUsers();  
	    }     
	    @RequestMapping(value="/add-user", method=RequestMethod.POST)  
	    public void addUser(@RequestBody User userRecord){  
	    	System.out.println("Entered into fn");
	        userService.addUser(userRecord);
	        System.out.println("Data inserted");
	    }  
	    @RequestMapping(value="/user/{id}", method=RequestMethod.GET)  
	    public String getUser(@PathVariable String id){ 
	    	System.out.println(id);
	        //return userService.getUser(id);
	    	Gson gson=new Gson();
	    	User user=userService.getUser(id);
	    	return gson.toJson(user);
	    }  
	    
//	    @RequestMapping(value="/useradd", method=RequestMethod.POST)
//	    public void Useradd(User user, 
//				BindingResult result){
//
//	    	//jdbc.execute("insert into user(id,name,email) values('1','Ashpreet','ash@gmail.com')");
//	    	
//	    	System.out.println("Data inserted successfully");
//	    	userService.addUser(user);
//	    }  
	    

}


