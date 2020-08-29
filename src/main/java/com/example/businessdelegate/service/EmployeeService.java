package com.example.businessdelegate.service;

import com.example.businessdelegate.delegate.BusinessService;
import com.example.businessdelegate.entities.Employee;
import com.example.businessdelegate.repository.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;


@Service
public class EmployeeService implements BusinessService<Employee> {

    EmployeeRepository repo;

    public EmployeeService() {
        repo = new EmployeeRepository();
    }

    public Employee add(Employee emp) {
        emp = repo.save(emp);
        System.out.println("Employee saved::" + emp);
        return emp;
    }
    public Optional<Employee> findById(long empId) throws Exception {
        Optional<Employee> emp = repo.findById(empId);
        System.out.println("Employee found::" + emp);
        return emp;
    }
    public Iterable<Employee> findAll() throws Exception {
        return repo.findAll();
    }
    public void deleteById(Employee emp) {
        repo.delete(emp);
        System.out.println("Employee deleted::" + emp);
    }
}