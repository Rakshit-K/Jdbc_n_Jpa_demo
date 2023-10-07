package com.rakshit.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.rakshit.jdbc.service.EmployeeService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			while(true) {
				System.out.println();
				System.out.println("Enter 1: Insert Employee");
				System.out.println("Enter 2: Update Employee");
				System.out.println("Enter 3: List All Employee");
				System.out.println("Enter 4: Delete Employee");
				System.out.println("Enter 5: Exit");
				System.out.println();
				
				Scanner scanner = new Scanner(System.in);
				int option = scanner.nextInt();
				EmployeeService employeeService = new EmployeeService();
				
				switch(option) {
				case 1:employeeService.insert();
				break;
				case 2:employeeService.update();
				break;
				case 3:employeeService.read();
				break;
				case 4:employeeService.delete();
				break;
				case 5:System.exit(0);
				break;
				default:System.out.println("Unexpected value : "+option);
				
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
