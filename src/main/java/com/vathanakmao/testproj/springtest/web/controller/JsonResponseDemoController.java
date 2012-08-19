package com.vathanakmao.testproj.springtest.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vathanakmao.testproj.springtest.model.Employee;
import com.vathanakmao.testproj.springtest.service.EmployeeService;

/**
 * Required org.codehaus.jackson.jackson-mapper-asl jar file in classpath 
 * and <mvc:annotation-driven/> in the context file so
 * Spring will convert any response objects to JSON string. 
 * Note that the Content-Type is application/json.
 * 
 * @author vathanakmao
 * 
 */
@Controller
@RequestMapping(value = "/jsonresponsedemo")
public class JsonResponseDemoController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

}
