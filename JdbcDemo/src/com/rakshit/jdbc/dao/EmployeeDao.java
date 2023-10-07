package com.rakshit.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rakshit.jdbc.bean.Employee;

public class EmployeeDao {
	public static Connection connection;
	public static Statement statement;
	public static PreparedStatement preparedStatement;

	public Connection getConnection() throws SQLException {
		try {
			if (connection == null) {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemos", "root", "root");
				return connection;
			} else {
				return connection;
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	public void insert(Employee employee) throws SQLException {
		try {
			connection = getConnection();
			String query = "insert into employee values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getEmployeeName());
			preparedStatement.setString(3, employee.getRole());
			preparedStatement.setDate(4, new Date(employee.getInserttime().getTime()));
			preparedStatement.setDouble(5, employee.getSalary());

			int rows = preparedStatement.executeUpdate();
			System.out.println("rows inserted : " + rows);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		

	}

	public void update(Employee employee) throws SQLException {
		try {
			connection = getConnection();
			String query = "update employee set employeeName=?,role=?,salary=? where employeeId=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, employee.getEmployeeName());
			preparedStatement.setString(2, employee.getRole());
			preparedStatement.setDouble(3, employee.getSalary());
			preparedStatement.setInt(4, employee.getEmployeeId());

			int rows = preparedStatement.executeUpdate();
			System.out.println("rows updated : " + rows);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		

	}

	public void read() throws SQLException {
		try {
			connection = getConnection();
			statement = connection.createStatement();
			String query = "select * from employee";
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println("id: " + resultSet.getInt("employeeId"));
				System.out.println("name: " + resultSet.getString("employeeName"));
				System.out.println("date: " + resultSet.getString("inserttime"));
				System.out.println("role: " + resultSet.getString("role"));
				System.out.println("salary: " + resultSet.getDouble("salary"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		

	}

	public void delete(Employee employee) throws SQLException {
		try {
			connection = getConnection();
			String query = "delete from employee where employeeId=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, employee.getEmployeeId());

			int rows = preparedStatement.executeUpdate();
			System.out.println("rows deleted : " + rows);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		

	}

}
