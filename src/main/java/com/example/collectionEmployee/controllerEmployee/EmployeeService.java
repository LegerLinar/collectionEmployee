package com.example.collectionEmployee.controllerEmployee;

import com.example.collectionEmployee.Employee.Employee;

public interface EmployeeService {
    void addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    Employee getEmployee(String firstName, String lastName);

    String getEmployeeList();
}
