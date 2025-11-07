<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Edit Employee Page</title>
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
			<img src="https://images5.alphacoders.com/107/thumb-1920-1070373.jpg"
			alt="Hero Image">
		
		<div class="edit-form">
			<h2>EDIT EMPLOYEE DETAILS</h2>

			<form action="saveeditedchanges" method="post">
			 <input type="hidden" name="id" value="${emp.id}"> 
				<div class="form-group">
					<label for="fullname">Full Name</label> <input type="text"
						id="fullname" name="fullname" placeholder="${emp.fullname}" value="${emp.fullname}">
				</div>

				<div class="form-group">
					<label for="email">Email Address</label> <input type="email"
						id="email" name="email" value="${emp.email}" placeholder="${emp.email}">
				</div>
				
				<div class="form-group">
				<label for="address">Employee Address</label>
				<input type="text" id="address" value ="${emp.address}" name="address" placeholder="${emp.address}" >
				</div>

				<div class="form-group">
					<label for="department">Department</label> <select id="department"
						name="department" required>
						<option value="${emp.department}"  selected>${emp.department} </option>
						<option value="backend">Backend Developer</option>
						<option value="frontend">Frontend Developer</option>
						<option value="data-engineer">Data Engineer</option>
						<option value="ui-ux">UI/UX Designer</option>
						<option value="qa">QA Engineer</option>
						<option value="devops">DevOps Engineer</option>
						<option value="project-manager">Project Manager</option>
					</select>
				</div>

				<div class="form-group">
					<label for="salary">Salary</label> <input type="text"
						id="salary" name="salary" placeholder="${emp.salary}" value="${emp.salary}"
						>
				</div>
				
				


				<div class="form-group">
					<button type="submit" class="btn">Save Changes</button>
				</div>
			</form>
		</div>
	</section>

	<footer>
		<h3>Created By : Vikram Choudhary</h3>
	</footer>
</body>
</html>
