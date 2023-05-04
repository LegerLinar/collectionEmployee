package com.example.collectionEmployee.exceptions;

import com.example.collectionEmployee.controllerEmployee.EmployeeService;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
