package com.project.employee.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.project.employee.dao.EmployeeDAO;
import com.project.employee.model.Employee;

public class EmployeeService {
	private Employee emp;
	private EmployeeDAO e = new EmployeeDAO();

	public EmployeeService(Employee emp) {
		this.emp = emp;
	}
	public EmployeeService() {
		
	}
	


	public boolean isEmailValid(String email) {
	    // Define a proper email regex pattern
	    String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

	    // Compile the pattern
	    Pattern pattern = Pattern.compile(emailRegex);

	    // Match the given email with the pattern
	    Matcher matcher = pattern.matcher(email);

	    // Return true if it matches, false otherwise
	    return matcher.matches();
	}
	
	public boolean isEmailAvailable(String email) {
		if(e.checkEmail(email)) {
			return false;
		}else {
			return true;
		}
		
	}


	public boolean save() {
		return e.register(emp.getFullname(), emp.getEmail(), emp.getAddress(), emp.getDepartment(), emp.getSalary());	
	
	}
	
	public Employee editable(String id) {
		return e.editableEmployee(id);
	}
	
	public List<Employee> showAllEmployees(){
		
		return e.read();
	}
	
	public boolean saveChanges() {
		return e.saveChanges(emp);
	}
	public boolean delete(Integer id) {
		return e.delete(id);
	}
}
