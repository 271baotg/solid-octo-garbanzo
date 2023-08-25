package com.example.jpasample.controller;


import com.example.jpasample.entity.Employee;
import com.example.jpasample.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee createNew(@RequestBody Employee employee){
//        employee.setId(0); // entityManager.merge() will create new if the id = 0 and update if id # 0
        return employeeService.create(employee);
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        return employeeService.update(employee);
    }

    @DeleteMapping("/employees/{idEmployee}")
    public void deleteEmpoyee(@PathVariable int idEmployee){
        employeeService.deleteById(idEmployee);
    }

}
