package com.example.collectionEmployee.controllerEmployee;

import com.example.collectionEmployee.exceptions.EmployeeAlreadyAddedException;
import com.example.collectionEmployee.exceptions.EmployeeNotFoundException;
import com.example.collectionEmployee.exceptions.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class ControllerEmployee {
    private final EmployeeService employeeService;

    public ControllerEmployee(EmployeeService employeeService) {
        this.employeeService = new EmployeeServiceImpl();
    }

    @GetMapping
    public String readme() {
        return "Добро пожаловать на страницу управления списком сотрудников";
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        try {
            employeeService.addEmployee(firstName, lastName);
        } catch (EmployeeAlreadyAddedException e) {
            return e.getMessage();
        } catch (EmployeeStorageIsFullException e) {
            return e.getMessage();
        }
        return "Сотрудник " + firstName + " " + lastName + " добавлен";
    }

    @GetMapping(path = "/find")
    public String getEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        String employee = "";
        try {
            employee = "" + employeeService.getEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
        return employee;
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        try {
            employeeService.removeEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
        return "Сотрудник" + firstName + " " + lastName + " удалён";
    }

    @GetMapping(path = "/employeeList")
    public String getEmployeeList() {
        return employeeService.getEmployeeList();
    }

}
