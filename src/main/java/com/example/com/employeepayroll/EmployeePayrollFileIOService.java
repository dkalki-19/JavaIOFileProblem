package com.example.com.employeepayroll;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIOService {

    public static final String PAYROLL_FILE_NAME = "payroll-file.txt";

    public void writeData(List<EmployeePayrollData> employeePayrollList) {
        StringBuffer buffer = new StringBuffer();
        employeePayrollList.forEach(emp -> buffer.append(emp.toString()).append("\n"));

        try {
            Files.write(Paths.get(PAYROLL_FILE_NAME), buffer.toString().getBytes());
            System.out.println("Payroll written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
