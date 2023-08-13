package com.example.spring5webapp.Service;

import java.util.List;

import com.example.spring5webapp.Dto.EmployeeDetails;
import com.example.spring5webapp.Entity.Employee;

public interface EmployeeService {

	public List<EmployeeDetails> getEmployees();
	public Employee getEmployeeById(int id);
	EmployeeDetails postEmployeeDetails(Employee employee);
	String deleteEmployeeById(int id);
}
