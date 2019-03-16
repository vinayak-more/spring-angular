package com.vinayak.demo.controller;

import java.util.List;

import com.vinayak.demo.model.Employee;
import com.vinayak.demo.model.EmployeeFilter;
import com.vinayak.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public List<Employee> getAllEmployees(@RequestBody EmployeeFilter filter){
        System.out.println(filter);
        List<Employee> allEmployees = service.getAllEmployees(filter);
        System.out.println("Employee size"+allEmployees.size());
        return allEmployees;
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public String addEmployees(){
        service.addEmployees();
        return "done";
    }
}