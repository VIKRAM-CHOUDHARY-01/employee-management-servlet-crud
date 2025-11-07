package com.project.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.employee.model.Employee;
import com.project.employee.service.EmployeeService;

@WebServlet("/saveeditedchanges")
public class SaveEditedChanges extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("fullname");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String department = req.getParameter("department");
		String salary = req.getParameter("salary");
		
		Employee emp = new Employee(id, name, email, address, department, salary);
		
		EmployeeService empService = new EmployeeService(emp);
		if (empService.saveChanges()) {
			EmployeeServlet.showMessagePage(resp,
					"Succcessfully Edited The Information, Check the saved changes on the employess list", "green",
					"allemployeesservlet", "All Employees");

		} else {
			EmployeeServlet.showMessagePage(resp,
					"There is some Database Error No Changes Made,  Please Contact Vikram", "red",
					"allemployeesservlet", "All Employees");
		}

	}
}
