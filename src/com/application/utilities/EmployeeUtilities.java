package com.application.utilities;


import com.application.domain.Employee;
import com.application.domain.Employees;
import com.application.exceptions.InvalidEmployeeIdException;
import com.application.exceptions.NameTooShortException;

public class EmployeeUtilities {
    public Boolean employeeExists(Employees givenEmployees, Employee givenEmployee){
        return  givenEmployees.findBySurname(givenEmployee.getSurname())!=null;
    }
    public Integer validateEmployeeId(String givenName) throws InvalidEmployeeIdException {
        try{
            Integer ans=Integer.valueOf(givenName);
            return  ans;
        }
        catch(NumberFormatException e){
            throw new InvalidEmployeeIdException();
        }
    }
    public void validateEmployeeName(String firstName, String surname) throws NameTooShortException {
        if(firstName.length()+surname.length()<6){
            throw new NameTooShortException();
        }
    }
}

