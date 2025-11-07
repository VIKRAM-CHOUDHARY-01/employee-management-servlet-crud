package com.project.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.employee.service.EmployeeService;

@WebServlet("/deleteemployee")
public class DeleteEmployee extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(req.getParameter("id"));
		EmployeeService emp = new EmployeeService();
		if(emp.delete(id)) {
			EmployeeServlet.showMessagePage(resp,
					"Succcessfully Deleted The Employee Data", "green",
					"allemployeesservlet", "All Employees");
		}else {
			EmployeeServlet.showMessagePage(resp,
					"Database Related Error Employee Data is not Deleted, Please Contact Vikram", "red",
					"allemployeesservlet", "All Employees");
		}
		
	}
}
