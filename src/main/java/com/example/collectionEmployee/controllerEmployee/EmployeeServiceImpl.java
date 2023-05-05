package com.example.collectionEmployee.controllerEmployee;

import com.example.collectionEmployee.Employee.Employee;
import com.example.collectionEmployee.exceptions.EmployeeAlreadyAddedException;
import com.example.collectionEmployee.exceptions.EmployeeNotFoundException;
import com.example.collectionEmployee.exceptions.EmployeeStorageIsFullException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int LIST_CAPACITY = 5;
    List<Employee> employeeList = new ArrayList<>(LIST_CAPACITY);


    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.size() > LIST_CAPACITY) {
            throw new EmployeeStorageIsFullException("Лимит количества сотрудников в отделе превышен");
        }
        else if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Указанный сотрудник уже есть в отделе");
        }
        employeeList.add(employee);
       return employee;


    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeeList.remove(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

    @Override
    public Employee getEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employeeList.get(employeeList.indexOf(employee));
    }

    public List getEmployeeList(){
        return employeeList;
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({EmployeeAlreadyAddedException.class})
//        public void handleEmployeeAlreadyAddedException(EmployeeAlreadyAddedException e){
//            e.getMessage();
//    }
}
