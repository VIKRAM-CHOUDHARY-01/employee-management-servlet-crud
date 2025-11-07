package com.project.employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.employee.model.Employee;
import com.project.employee.service.EmployeeService;

@WebServlet("/editemployeeservlet")
public class EditEmployeeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		EmployeeService empSerivce = new EmployeeService();
		Employee emp = empSerivce.editable(id);
		
		req.setAttribute("emp", emp);
		RequestDispatcher rd = req.getRequestDispatcher("editemployee.jsp");
		rd.forward(req, resp);
		
	}

}
