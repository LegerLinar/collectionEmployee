package com.example.collectionEmployee.controllerEmployee;

import com.example.collectionEmployee.Employee.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee getEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.getEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/employeeList")
    public List getEmployeeList() {
        return employeeService.getEmployeeList();
    }


}
