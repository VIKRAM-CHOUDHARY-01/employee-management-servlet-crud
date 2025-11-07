package com.project.employee.model;

public class Employee {
	private Integer id;
	private String fullname;
	private String email;
	private String address;
	private String department;
	private String salary;
	
	
	
	public Employee(Integer id, String fullname, String email, String address, String department, String salary) {
		super();
		this.id=id;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.department = department;
		this.salary = salary;
	}
	public Employee() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullname=" + fullname + ", email=" + email + ", address=" + address + ", department="
				+ department + ", salary=" + salary + "]";
	}
	
	
}
