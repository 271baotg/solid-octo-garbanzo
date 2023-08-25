package com.example.jpasample.service;


import com.example.jpasample.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee update(Employee employee);
    Employee create(Employee employee);

    Employee findById(int id);
    void deleteById(int id);

}
