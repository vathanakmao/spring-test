package com.vathanakmao.testproj.springtest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vathanakmao.testproj.springtest.model.Employee;
import com.vathanakmao.testproj.springtest.service.EmployeeService;
import com.vathanakmao.testproj.springtest.util.Console;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new ArrayList<Employee>();
        employees.add(new Employee(1L, "Sok San"));
        employees.add(new Employee(2L, "Sen Sok"));
    }

    public Employee getEmployee(Long id) {
        for(Employee emp : employees) {
            Console.print("Employee [id = " + emp.getId() + ", name = " + emp.getName() + "]");

            if (emp.getId().equals(id)) {
                return emp;
            }
        }

        return null;
    }

    public List<Employee> getEmployees() {
        return employees; // TODO: return a clone instead
    }

}
