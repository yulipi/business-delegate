package com.example.businessdelegate.delegate;

import com.example.businessdelegate.service.EmployeeService;

public class BusinessLookup {

    private EmployeeService employeeService;

    public BusinessService getBusinessService(ServiceType serviceType) {
        if (serviceType.equals(ServiceType.EMPLOYEE)) {
            return employeeService;
        }
        return null;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

}
