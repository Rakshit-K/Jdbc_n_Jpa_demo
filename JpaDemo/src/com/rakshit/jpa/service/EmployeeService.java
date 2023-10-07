package com.rakshit.jpa.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import com.rakshit.jpa.entity.Employee;
import com.rakshit.jpa.dao.EmployeeDao;

public class EmployeeService {

	public void insert() throws Exception {
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

	public void update() throws Exception {
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

	public void read() throws Exception {
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = new Employee();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter existing employee id");
		employee.setEmployeeId(scanner.nextInt());
		employeeDao.read(employee);

	}

	public void delete() throws Exception {
		Employee employee = new Employee();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter existing employee id");
		employee.setEmployeeId(scanner.nextInt());
		
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.delete(employee);

	}
	
	public void readAll() throws Exception {
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.readAll();

	}
	
	public void idRange() throws Exception {
		EmployeeDao employeeDao = new EmployeeDao();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter from id");
		int from = scanner.nextInt();
		
		System.out.println("Enter to id");
		int to = scanner.nextInt();
		employeeDao.idRange(from, to);

	}
	
	public void nameLike() throws Exception {
		EmployeeDao employeeDao = new EmployeeDao();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter name like pattern");
		String pattern = scanner.next();
		
		employeeDao.nameLike(pattern);

	}

}
