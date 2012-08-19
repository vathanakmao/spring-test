package com.vathanakmao.testproj.springtest.service;

import java.util.List;

import com.vathanakmao.testproj.springtest.model.Employee;

public interface EmployeeService {
    public List<Employee> getEmployees();

    public Employee getEmployee(Long id);
}
