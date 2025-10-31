package com.example.com.employeepayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	
	public enum IOService { CONSOLE_IO, FILE_IO }

//	public enum IOService {CONSOLE_IO, FILE_IO , DB_IO , REST_IO}
	
	List<EmployeePayrollData> employeePayRollList = new ArrayList<EmployeePayrollData>();
	
	EmployeePayrollService(){
	}
	
	EmployeePayrollService(List<EmployeePayrollData> employeePayrollList){
		this.employeePayRollList = employeePayrollList;
	}
	
	
	
	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
		EmployeePayrollService empService = new EmployeePayrollService(employeePayrollList);
		 Scanner sc = new Scanner(System.in);
		 empService.readDetails(sc);
		 empService.writeEmployeePayrollData(IOService.CONSOLE_IO); 
		 
		
	}

	private void readDetails(Scanner sc) {
		System.out.println("Enter Your EmployeeId : ");
		int id = sc.nextInt();
		System.out.println("Enter Your Name : ");
		String name = sc.next();
		System.out.println("Enter Your Salary : ");
		Double sal = sc.nextDouble();
		employeePayRollList.add(new EmployeePayrollData(id,name,sal));
		
	}
	
	public void writeEmployeePayrollData(IOService ioService) {
	    if (ioService.equals(IOService.CONSOLE_IO)) {
	        System.out.println("Writing Employee Payroll to Console\n" + employeePayRollList);
	    }
	    else if (ioService.equals(IOService.FILE_IO)) {
	        new EmployeePayrollFileIOService().writeData(employeePayRollList);
	    }
	}
}
