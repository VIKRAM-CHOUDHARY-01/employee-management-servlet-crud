package com.project.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.employee.model.Employee;
import com.project.employee.service.EmployeeService;

/**
 * Servlet implementation class AllEmployeesServlet
 */
@WebServlet("/allemployeesservlet")
public class AllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllEmployeesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		EmployeeService es = new EmployeeService();
		List<Employee> employeeList = es.showAllEmployees();

		req.setAttribute("employeeList", employeeList);
		RequestDispatcher rd = req.getRequestDispatcher("allemployees.jsp");
		rd.forward(req, resp);

	}

}
