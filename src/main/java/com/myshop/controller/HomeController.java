package com.myshop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.dto.TestDto;
import com.myshop.entities.User;

import java.security.Principal;

import javax.validation.Valid;
import javax.validation.Validation;

@RestController
public class HomeController {

    @GetMapping("/")
    public String welcome() {
    	
        return "wlcome ";
    }
    @GetMapping("/home")
    public String home(Principal principal) {
    	
    	
    	return "Hello, " +principal.getName();
    }

    
   
    @PostMapping("/test")
    public String test( @Valid @RequestBody TestDto testDto) {
    	System.out.println("hellodsjlkfjsdl;kfd");
    	@Valid User user;
    	return "This is secured!";
    }
    
}