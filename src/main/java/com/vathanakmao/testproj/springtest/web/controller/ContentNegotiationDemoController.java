package com.vathanakmao.testproj.springtest.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vathanakmao.testproj.springtest.model.EmployeeList;
import com.vathanakmao.testproj.springtest.service.EmployeeService;

/**
 * Using ContentNegotiatingViewResolver, you don't need to create more than one
 * handler methods/controllers for different views or response content types.
 * The getEmployees() method below will handle different more than one request
 * URIs such as /employees, /employees.json and /employees.xml.
 * 
 * @author vathanakmao
 * 
 */
@Controller
@RequestMapping(value = "/contentnegotiationdemo")
public class ContentNegotiationDemoController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String getEmployees(Model model) {
		model.addAttribute("employees",
				new EmployeeList(employeeService.getEmployees()));
		return "employees";
	}

}
