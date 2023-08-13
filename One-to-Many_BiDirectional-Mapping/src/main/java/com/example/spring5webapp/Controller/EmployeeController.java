package com.example.spring5webapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring5webapp.Dto.EmployeeDetails;
import com.example.spring5webapp.Entity.Employee;
import com.example.spring5webapp.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping 
	public ResponseEntity<List<EmployeeDetails>> getEmployees() {
		return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);

	}

	@PostMapping
	public ResponseEntity<EmployeeDetails> postEmployeeDetails(@RequestBody Employee employee) {
		
		return new ResponseEntity<>(employeeService.postEmployeeDetails(employee), HttpStatus.OK);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id){
		return new ResponseEntity<>(employeeService.deleteEmployeeById(id), HttpStatus.OK);
		
	}
}
