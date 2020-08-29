package com.example.businessdelegate.repository;

import com.example.businessdelegate.entities.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository {

    public Employee save(Employee e) {
        System.out.println("Employee " + e + " added");
        return e;
    }

    public Optional<Employee> findById(long id) throws IOException {
        return Optional.of(new Employee());
    }

    public List<Employee> findAll() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "[{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Shamik Mitra\",\n" +
                "    \"address\": \"BagBazar\",\n" +
                "    \"sex\": \"M\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"Samir Mitra\",\n" +
                "    \"address\": \"BagBazar\",\n" +
                "    \"sex\": \"M\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 3,\n" +
                "    \"name\": \"Swastika Basu\",\n" +
                "    \"address\": \"Baranagar\",\n" +
                "    \"sex\": \"F\"\n" +
                "  }]";

        List<Employee> employees = Arrays.asList(mapper.readValue(json, Employee[].class));
        return employees;
    }

    public void delete(Employee e) {
        System.out.println("Employee " + e + " Removed");
    }
}
