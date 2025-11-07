package com.project.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.WhileStatement;

import com.project.employee.model.Employee;
import com.project.employee.util.DBConnection;

public class EmployeeDAO {

	public boolean checkEmail(String email) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(DBConnection.url, DBConnection.username,
				DBConnection.password);
				PreparedStatement st = conn
						.prepareStatement("SELECT * FROM " + DBConnection.tableName + " WHERE email=?")) {

			st.setString(1, email);
			ResultSet rst = st.executeQuery();
			return rst.next();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;

	}

	public boolean register(String fullname, String email, String address, String department, String salary) {


		try (Connection conn = DriverManager.getConnection(DBConnection.url, DBConnection.username,
				DBConnection.password);
				PreparedStatement pst = conn
						.prepareStatement("INSERT INTO " + DBConnection.tableName + " VALUES (?,?,?,?,?,?)");) {

			pst.setString(1, null);
			pst.setString(2, fullname);
			pst.setString(3, email);
			pst.setString(4, address);
			pst.setString(5, department);
			pst.setString(6, salary);

			int rowAffected = pst.executeUpdate();
			if (rowAffected > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;

	}

	public List<Employee> read() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(DBConnection.url, DBConnection.username,
				DBConnection.password);
				PreparedStatement st = conn.prepareStatement("SELECT * FROM " + DBConnection.tableName);) {

			ResultSet rst = st.executeQuery();

			List<Employee> employessList = new ArrayList<Employee>();

			while (rst.next()) {
				Employee emp = new Employee(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getString(6));
				employessList.add(emp);
			}

			return employessList;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;

	}

	public Employee editableEmployee(String id) {

//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

		Employee emp = new Employee();
		try (Connection conn = DriverManager.getConnection(DBConnection.url, DBConnection.username,
				DBConnection.password);
				PreparedStatement pst = conn
						.prepareStatement("SELECT * FROM " + DBConnection.tableName + " WHERE id =?");) {
			pst.setString(1, id);
			ResultSet rst = pst.executeQuery();
			

			while (rst.next()) {
				emp.setId(Integer.parseInt(rst.getString(1)));
				emp.setFullname(rst.getString(2));
				emp.setEmail(rst.getString(3));
				emp.setAddress(rst.getString(4));
				emp.setDepartment(rst.getString(5));
				emp.setSalary(rst.getString(6));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return emp;

	}

	public boolean saveChanges(Employee emp) {
		
		try(Connection conn = DriverManager.getConnection(DBConnection.url, DBConnection.username, DBConnection.password);
				PreparedStatement pst = conn.prepareStatement("UPDATE " + DBConnection.tableName + " SET fullname=?, email=?, address=?, department=?, salary=? WHERE id=?");){
				
			pst.setString(1, emp.getFullname());
			pst.setString(2, emp.getEmail());
			pst.setString(3, emp.getAddress());
			pst.setString(4, emp.getDepartment());
			pst.setString(5, emp.getSalary());
			pst.setString(6, String.valueOf(emp.getId()));;
			
			int result = pst.executeUpdate();
			if(result>0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean delete(Integer id) {
		try(Connection conn = DriverManager.getConnection(DBConnection.url, DBConnection.username, DBConnection.password);
		PreparedStatement pst = conn.prepareStatement("DELETE FROM " + DBConnection.tableName + " WHERE id=?");){
			pst.setString(1,String.valueOf(id));
			int rowAffected = pst.executeUpdate();
			if(rowAffected>0) {
				return true;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
