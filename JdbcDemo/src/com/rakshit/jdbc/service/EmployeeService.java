package com.rakshit.jdbc.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import com.rakshit.jdbc.bean.Employee;
import com.rakshit.jdbc.dao.EmployeeDao;

public class EmployeeService {

	public void insert() throws SQLException {
		Employee employee = new Employee();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter employee id");
		employee.setEmployeeId(scanner.nextInt());
		System.out.println("Enter employee name");
		employee.setEmployeeName(scanner.next());
		System.out.println("Enter employee role");
		employee.setRole(scanner.next());
		System.out.println("Enter employee salary");
		employee.setSalary(scanner.nextDouble());
		employee.setInserttime(new Date());
		
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.insert(employee);

	}

	public void update() throws SQLException {
		Employee employee = new Employee();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter existing employee id");
		employee.setEmployeeId(scanner.nextInt());
		System.out.println("Enter updated employee name");
		employee.setEmployeeName(scanner.next());
		System.out.println("Enter updated employee role");
		employee.setRole(scanner.next());
		System.out.println("Enter updated employee salary");
		employee.setSalary(scanner.nextDouble());
		employee.setInserttime(new Date());
		
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.update(employee);

	}

	public void read() throws SQLException {
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.read();

	}

	public void delete() throws SQLException {
		Employee employee = new Employee();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter existing employee id");
		employee.setEmployeeId(scanner.nextInt());
		
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.delete(employee);

	}

}
