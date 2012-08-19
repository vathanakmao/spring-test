package com.vathanakmao.testproj.springtest.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vathanakmao.testproj.springtest.model.Employee;
import com.vathanakmao.testproj.springtest.model.EmployeeList;
import com.vathanakmao.testproj.springtest.service.EmployeeService;

@Controller
@RequestMapping(value = "/xmlresponsedemo")
public class XmlResponseDemoController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmployees() {
        return new EmployeeList(employeeService.getEmployees());
    }

}
