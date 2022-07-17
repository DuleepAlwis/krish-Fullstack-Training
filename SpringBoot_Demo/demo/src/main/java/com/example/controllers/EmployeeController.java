package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Repository.EmployeeRepository;
import com.example.model.EmployeeEntity;

@CrossOrigin(origins="http://localhost")  

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public EmployeeEntity save(@RequestBody EmployeeEntity e){
		
		return empRepo.save(e);
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String getValue() {
		return "HelloWorld";
	}

}
