package com.application.ui;

import com.application.domain.Department;
import com.application.domain.Employee;
import com.application.domain.ExpenseClaim;
import com.application.exceptions.InvalidEmployeeIdException;
import com.application.exceptions.NameTooShortException;
import com.application.utilities.EmployeeUtilities;

import java.time.LocalDateTime;
import java.util.Scanner;

public class UI {

    public Employee registerNewEmployee() {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        EmployeeUtilities employeeUtilities = new EmployeeUtilities();

        boolean idIsValid = false;
        while (!idIsValid) {
            System.out.println("Enter the id");
            String inputId = scanner.nextLine();
            try {
                Integer id = employeeUtilities.validateEmployeeId(inputId);
                employee.setId(id);
                idIsValid = true;
            } catch (InvalidEmployeeIdException e) {
                System.out.println("This id is NOT VALID Please type again");
            }
        }


        System.out.println("Enter the title");
        String title = scanner.nextLine();
        employee.setTitle(title);

        boolean nameIsValid = false;
        while (!nameIsValid) {
            System.out.println("Enter the first name");
            String firstName = scanner.nextLine();
            employee.setFirstName(firstName);

            System.out.println("Enter the surname");
            String surname = scanner.nextLine();
            employee.setSurname(surname);

            try {
                employeeUtilities.validateEmployeeName(firstName, surname);
                nameIsValid = true;
            } catch (NameTooShortException e) {
                System.out.println("Name is not valid- Try Again");
            }
        }


        System.out.println("Enter the JobTitle");
        String jobTile = scanner.nextLine();
        employee.setJobTitle(jobTile);

        boolean isDeptValid = false;
        while (!isDeptValid) {
            System.out.println("Enter the department");
            String department = scanner.nextLine();
            try {
                Department d = Department.valueOf(department.toUpperCase());
                employee.setDepartment(d);
                isDeptValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Input Department is not valid, Try Again");
            }

        }

        return employee;

    }

    public ExpenseClaim registerNewExpenseClaim() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the claim ID");
        int claimId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the Employee Id");
        int employeeId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("enter the dateOfClaim");
        LocalDateTime dateOfClaim = LocalDateTime.now();

        System.out.println("Enter the total Amount");
        Double totalAmount = scanner.nextDouble();
        scanner.nextLine();

        ExpenseClaim expenseClaim = new ExpenseClaim(claimId, employeeId, dateOfClaim, totalAmount);
        return expenseClaim;
    }

}
