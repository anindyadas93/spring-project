package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Test;
import com.example.demo.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;
	
    @GetMapping("/testing")
    private String getAllEmployees() {
        return "Hello";
    }
    
    @GetMapping("/testing/{v1}/{v2}")
    private int getSum(@PathVariable("v1") int v1, @PathVariable("v2") int v2) {
        int result = testService.summation(v1, v2);
    	return result;
    }
    
    @PostMapping("/testing-post")
    private int getSumPost(@RequestBody Test test) {
        int result = testService.addition(test);
    	return result;
    }
}
