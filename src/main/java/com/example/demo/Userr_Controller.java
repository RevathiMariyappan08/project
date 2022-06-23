package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Userr_Controller {
	@Autowired
	Userr_Service user;
	@GetMapping("/users")
	public ResponseEntity< List< Userr >> users() {
		List<Userr>users=new ArrayList<>();
		users.add(new Userr(1,"priya"));
		users.add(new Userr(2,"selvi"));
		users.add(new Userr(3,"sri"));
		HttpHeaders headers=new HttpHeaders();
		headers.add("Responded", "UserController");
		return ResponseEntity.accepted().headers(headers).body(users);
		
	}
	@PostMapping("/addusers") 
	public String addusers(@RequestBody List<Userr>u) {
		return user.addallusers(u);
	}
	@GetMapping("/getusers")
	public ResponseEntity<List<Userr>>getallusers() throws UserNotFoundException {
		try {
		List<Userr>getall=user.getallusers();
		if(getall.isEmpty()) {
			throw new UserNotFoundException("not found");
		}
			return new ResponseEntity<>(getall,HttpStatus.OK);
		}catch(UserNotFoundException e) {
			throw new UserNotFoundException("Internal server error");
		}
	}

		
		
	
	@DeleteMapping("/deleteusers/{id}")
	public String deleteusers(@PathVariable Integer id) {
		return user.deleteusers(id);
	}


}
