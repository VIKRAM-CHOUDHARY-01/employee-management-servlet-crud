package com.project.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.employee.model.Employee;
import com.project.employee.service.EmployeeService;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fullName = request.getParameter("fullname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String department = request.getParameter("department");
		String salary = request.getParameter("salary");
		Integer id = null;

		Employee emp = new Employee(id,fullName, email, address, department, salary);

		EmployeeService esp = new EmployeeService(emp);

		if (esp.isEmailAvailable(email)) {

			if (esp.save()) {
				showMessagePage(response, "Successfully Registered! Check Your All Employees", "green",
						"allemployeesservlet", "All Employees");

			} else {
				showMessagePage(response,
						"Database Related Problem Occured, Please tell Vikram to check IDE console for errors.",
						"red", "tel:Number to Show ni Karne Chayie, Sorry.", "Call Vikram");

			}

		} else {
			showMessagePage(response, "Email Already in Use, Please Use Another Email. Employee is not Added", "red",
					"registrationform.html", "Add New Employee");
		}
		
		

	}

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		service(request, response);

	}

	public static void showMessagePage(HttpServletResponse response, String message, String color, String backLink,
			String backText) throws IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("  <meta charset='UTF-8'>");
		out.println("  <title>Message Page</title>");
		out.println("  <link rel=\"stylesheet\" href=\"styles.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("  <header>");
		out.println("    <div class='container'>");
		out.println("      <h1><a href='Home.html' class='logo-link'>Servlet CRUD</a></h1>");
		out.println("      <nav class='menu'>");
		out.println("        <a href='allemployeesservlet'>See All Employees</a>");
		out.println("        <a href='registrationform.html'>Add Employee</a>");
		out.println("      </nav>");
		out.println("    </div>");
		out.println("  </header>");
		out.println("  <section class='hero'>");
		out.println("    <img src='https://images5.alphacoders.com/107/thumb-1920-1070373.jpg' alt='Hero Image'>");
		out.println("    <div class='message-box'>");
		out.println("      <h2 style='color:" + color + ";'>" + message + "</h2>");
		out.println("      <a href='" + backLink + "' class='back-link'>" + backText + "</a>");
		out.println("    </div>");
		out.println("  </section>");
		out.println("  <footer>");
		out.println("    <h3>Created By : Vikram Choudhary</h3>");
		out.println("  </footer>");
		out.println("</body>");
		out.println("</html>");

		out.close();

	}

}
