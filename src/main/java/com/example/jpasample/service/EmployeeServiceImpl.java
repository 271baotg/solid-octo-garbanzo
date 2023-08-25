package com.example.jpasample.service;

import com.example.jpasample.dao.EmployeeRepository;
import com.example.jpasample.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee create(Employee employee) {
        employee.setId(0);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }


    @Override
    public void deleteById(int id) {
        Employee employee = new Employee();
        if(employeeRepository.findById(id).isPresent()) {
            employee = employeeRepository.findById(id).get();
            employeeRepository.delete(employee);
        }
    }
}
