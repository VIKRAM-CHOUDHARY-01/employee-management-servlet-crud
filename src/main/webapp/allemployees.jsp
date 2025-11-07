<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>All Employees Page</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<header>
		<div class="container">
			<h1>
				<a href="Home.html" class="logo-link">Servlet CRUD</a>
			</h1>
			<nav class="menu">
				<a href="allemployeesservlet">See All Employees</a> <a
					href="registrationform.html">Add Employee</a>
			</nav>
		</div>
	</header>

	<section class="hero">
		
		<div class="all-employees">
			<h2>All Employees</h2>
			<table border="1" cellpadding="10" cellspacing="0">
				<thead>
					<tr>
						<th>ID</th>
						<th>Full Name</th>
						<th>Email</th>
						<th>Address</th>
						<th>Department</th>
						<th>Salary</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="emp" items="${employeeList}">
						<tr>
							<td>${emp.id}</td>
							<td>${emp.fullname}</td>
							<td>${emp.email}</td>
							<td>${emp.address}</td>
							<td>${emp.department}</td>
							<td>${emp.salary}</td>
							<td><a href="editemployeeservlet?id=${emp.id}">Edit</a> | <a
								href="deleteemployee?id=${emp.id}"
								onclick="return confirm('Are you sure?')">Delete</a></td>
						</tr>
					</c:forEach>


					<c:if test="${empty employeeList}">
						<tr>
							<td colspan="7" style="text-align: center;">No employees
								found.</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div>
	</section>

	<footer>
		<h3>Created By : Vikram Choudhary</h3>
	</footer>
</body>
</html>
