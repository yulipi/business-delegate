package com.example.businessdelegate.controller;

import com.example.businessdelegate.delegate.BusinessDelegate;
import com.example.businessdelegate.delegate.BusinessLookup;
import com.example.businessdelegate.delegate.ServiceType;
import com.example.businessdelegate.entities.Employee;
import com.example.businessdelegate.service.EmployeeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RestController
public class EmployeeController {

    BusinessDelegate service;

    @PostConstruct
    private void postConstruct() {
        BusinessDelegate businessDelegate = new BusinessDelegate();
        BusinessLookup businessLookup = new BusinessLookup();
        businessLookup.setEmployeeService(new EmployeeService());

        businessDelegate.setLookupService(businessLookup);
        businessDelegate.setServiceType(ServiceType.EMPLOYEE);
        this.service = businessDelegate;
    }

    @RequestMapping("/TCS/employees")
    public Iterable<Employee> findAllEmployee() throws Exception {
        return (Iterable)service.findAll();
    }
    @RequestMapping("/TCS/employee/{id}")
    public Employee findbyId(@PathVariable Long id) throws Exception {
        Optional<Employee> emplyoeeContainer = (Optional)service.findById(id);
        return emplyoeeContainer.isPresent()?emplyoeeContainer.get():null;
    }
    @RequestMapping("/TCS/employee/addDemoEmployee")
    public Employee addEmployee() {
        Employee emp = new Employee();
        emp.setName("Demo Demo");
        emp.setSex("M");
        emp.setAddress("Demo");
        return (Employee) service.add(emp);
    }
    @RequestMapping("/TCS/employee/delete/{id}")
    public String delete(@PathVariable Long id) throws Exception {
        Optional<Employee> emp = (Optional) service.findById(id);
        if(emp.isPresent()) {
            service.deleteById(emp.get());
            return "deleted Successfully";
        }
        return "Employee Not Exists, Not able to delete";
    }
}
