package com.application;

import com.application.domain.Employees;
import com.application.exceptions.EmployeeNotFoundException;
import com.application.ui.UI;

import java.util.Scanner;

public class EmployeeExpenseManagement {
    public static void main(String[] args) {

        Employees employees = new Employees();
        UI ui = new UI();
        Scanner scanner = new Scanner(System.in);

        boolean exitWay = false;
        while (!exitWay) {

            System.out.println("Expense Management System");
            System.out.println("------xxxxxxx-------");
            System.out.println("Press 'e' for Add Employee\n" +
                    "Press 'c' for Add Employee\n" +
                    "Press 'p' for Add Employee\n" +
                    "Press 'x' for Add Employee\n");
            String option = scanner.nextLine();
            switch (option) {
                case "e":
                    employees.addEmployee(ui.registerNewEmployee());
                    break;
                case "c":
                    try {
                        employees.addExpenseClaim(ui.registerNewExpenseClaim());
                    } catch (EmployeeNotFoundException e) {
                        System.out.println("Try Again With new claimId");
                    }
                    break;
                case "p":
                    employees.printEmployees();
                    break;
                case "x":
                    exitWay = true;
                    break;
            }
        }

    }


}
