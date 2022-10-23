package com.application.domain;

import com.application.exceptions.EmployeeNotFoundException;

import java.util.HashSet;

public class Employees  {
    private HashSet<Employee> employees;

    public Employees() {
        this.employees = new HashSet<Employee>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);

    }

    public void printEmployees() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public Employee findBySurname(String givenSurname) {
        for (Employee emp : employees) {
            if (emp.getSurname() == givenSurname) {
                return emp;
            }
        }
        return null;
    }

    public boolean employeeExist(Integer id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void addExpenseClaim(ExpenseClaim claim) throws EmployeeNotFoundException {
        int empId = claim.getEmployeeId();

        if (!employeeExist(empId)) {
            throw new EmployeeNotFoundException();
        }

        for (Employee emp : employees) {
            if (emp.getId() == empId) {
                emp.getClaims().add(claim);
            }

        }

    }


}
