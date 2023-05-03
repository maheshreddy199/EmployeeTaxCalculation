package com.tasks.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.in.entity.Employee;
import com.tasks.in.entity.EmployeeEntity;
import com.tasks.in.entity.Tax;
import com.tasks.in.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/saveEmployee")
	public ResponseEntity<EmployeeEntity> save(@Valid @RequestBody Employee emp){
		EmployeeEntity em = service.save(emp);
		
		return new ResponseEntity<>(em,HttpStatus.OK);
	}
	
	@RequestMapping("/calculateTax/{id}")
	public ResponseEntity<Tax> savee(@PathVariable("id") long id){
		Tax tax = service.savee(id);
		return new ResponseEntity<>(tax,HttpStatus.OK);
	}
}
