package com.example.collectionEmployee.controllerEmployee;

import com.example.collectionEmployee.Employee.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee getEmployee(String firstName, String lastName);

    List getEmployeeList();
}
