
package com.example.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.graph.FullNodeEntity;
import com.example.entity.graph.PartialEntity;
import com.example.entity.jpa.user.Role;
import com.example.entity.jpa.user.User;
import com.example.entity.jpa.user.UserDetails;
import com.example.repository.graph.FullNodeEntityRepository;
import com.example.repository.graph.PartialEntityRepository;
import com.example.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	PartialEntityRepository partialEntityRepository;
	
	@Autowired
	FullNodeEntityRepository fullNodeEntityRepository;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/test")
	public void test() {
	    User owner = new User();
	    owner.setFirstName("Tiny");
	    owner.setLastName("Tim");
	    owner.setEmail("tiny.tim@test.com");
	    owner.setRole(Role.USER);
	    UserDetails userDetails = new UserDetails();
	    userDetails.setPassword("test");
	    Optional<User> ownerOpt = userService.create(owner, userDetails);
	    
	    FullNodeEntity fullNodeEntity = new FullNodeEntity();
	    fullNodeEntity.setName("Test Name");
	    fullNodeEntity.setDescription("Test Description");
	    fullNodeEntityRepository.save(fullNodeEntity);
	    
	    PartialEntity partialEntity = new PartialEntity();
	    partialEntity.setName("Test Name");
	    partialEntity.setDescription("Test Description");
	    partialEntityRepository.save(partialEntity);
	    
	}
}
