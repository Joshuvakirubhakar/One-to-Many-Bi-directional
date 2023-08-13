package com.example.spring5webapp.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring5webapp.Dto.EmployeeDetails;
import com.example.spring5webapp.Entity.Employee;
import com.example.spring5webapp.ExceptionHandler.IdNotFoundException;
import com.example.spring5webapp.Repository.EmployeeRepo;
import com.example.spring5webapp.Service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public List<EmployeeDetails> getEmployees() {
		List<Employee> employee = employeeRepo.findAll();
		List<EmployeeDetails> details = new ArrayList<EmployeeDetails>();
		for(Employee emp: employee) {
			EmployeeDetails emDetails = new EmployeeDetails();
			emDetails.setEmpid(emp.getEmployee_id());
			emDetails.setEmp_name(emp.getEmployee_name());
			emDetails.setEmp_email(emp.getEmployee_email());
			emDetails.setDepartment(emp.getDepartment().getDept_name());
			details.add(emDetails);
		}
		return details;

	}
	@Override
	public Employee getEmployeeById(int id) {
		Employee employee =null;
		try {
			employee = employeeRepo.findById(id).get();
		}catch (Exception e) {
			throw new IdNotFoundException("Employee with id: " +id +" Not found !!!");
		}
		employee.getDepartment().setEmployee(null); //To avoid infinite loop
		return employee;

	}
	@Override
	public EmployeeDetails postEmployeeDetails(Employee employee) {
		
		employeeRepo.save(employee);
		Employee employee1 = getEmployeeById(employee.getEmployee_id());

		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setEmpid(employee1.getEmployee_id());
		employeeDetails.setEmp_name(employee1.getEmployee_name());
		employeeDetails.setEmp_email(employee1.getEmployee_email());
		employeeDetails.setDepartment(employee1.getDepartment().getDept_name());
		return employeeDetails;

	}
	@Override
	public String deleteEmployeeById(int id){
		try {
			employeeRepo.delete(getEmployeeById(id));
		}catch (Exception e) {
			throw new IdNotFoundException("Employee with id: " +id +" Not found !!!");
		}
		return "Employee with : " +id+" Deleted !!!";
		
	}
}
