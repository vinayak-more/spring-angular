package com.vinayak.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.vinayak.demo.model.Employee;
import com.vinayak.demo.model.EmployeeFilter;
import com.vinayak.demo.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    private String[] fnames = { "Vianyak", "Raghav", "Supriya", "Satish", "Gaurav", "Prashant", "Vinod", "Kuldeep",
            "Nitin", "Jesu" };
    private String[] lnames = { "More", "Reddy", "Walkunde", "Puli", "Sinha", "Padma", "Shinde", "Mishra", "Alle",
            "Pillai" };
    private String[] designations = { "Developer", "Test Lead", "UI Developer", "Team Lead", "L2 Support",
            "Solutions Architect", "Software Engineer", "Tester", "Tester", "Product Owner" };
    private String[] addressStreets = { "AK Road", "MG Road", "JVLR", "Palm Beach Road", "Hill Road", "Walley Road",
            "Seaside Road", "Hi Road", "Mid Road", "Low Road" };
    private double[] salaries = { 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000 };
    private String[] addressCities = { "Mumbai", "Pune", "Banglore", "Hyderabad", "Delhi", "Patna", "Ahmedabad",
            "Mysoor", "Chennai", "Ranchi" };
    private String[] addressStates = { "Maharashra", "Maharastra", "Delhi", "Panjab", "Madhya Pradesh", "Uttar Pradesh",
            "Kerala", "Karnataka", "Tamil Nadu", "Telanagana" };

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public void addEmployees() {
        Random random = new Random();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i <= 100000; i++) {
            Employee e = new Employee();
            e.setFirstName(fnames[random.nextInt(10)]);
            e.setLastName(lnames[random.nextInt(10)]);
            e.setDesignation(designations[random.nextInt(10)]);
            e.setSalary(salaries[random.nextInt(10)]);
            e.setAddressStreet(addressStreets[random.nextInt(10)]);
            e.setAddressState(addressStates[random.nextInt(10)]);
            e.setAddressCity(addressCities[random.nextInt(10)]);
            e.setAddressCountry("India");
            employees.add(e);
        }
        repository.saveAll(employees);
    }

    public List<Employee> getAllEmployees(int page, String sortBy) {
        Pageable pageable = PageRequest.of(page, 100, Sort.by(sortBy).ascending());
        return repository.findAll(pageable).getContent();
    }

    public List<Employee> getAllEmployees(EmployeeFilter filter) {
        Pageable pageable = getPageable(filter);
        return repository.findAll(pageable).getContent();
    }

    private Pageable getPageable(EmployeeFilter filter) {
        PageRequest req = PageRequest.of(filter.getPageNumber(), filter.getPageSize());
        if (filter.getSortBy() != null && !filter.getSortBy().isEmpty()) {
            req = PageRequest.of(filter.getPageNumber(), filter.getPageSize(),
                    filter.isDescending() ? Direction.DESC : Direction.ASC, filter.getSortBy());
        }
        return req;
    }
}