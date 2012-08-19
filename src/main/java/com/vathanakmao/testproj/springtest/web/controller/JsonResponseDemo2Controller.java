package com.vathanakmao.testproj.springtest.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vathanakmao.testproj.springtest.service.EmployeeService;

/**
 * Required org.codehaus.jackson.jackson-mapper-asl jar file in classpath so
 * Spring will convert any response objects to JSON string.
 * 
 * @author vathanakmao
 * 
 */
@Controller
@RequestMapping(value = "/jsonresponsedemo2")
public class JsonResponseDemo2Controller {

	@Autowired
	private EmployeeService employeeService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployees() {
		return new ResponseEntity(employeeService.getEmployees(),
				org.springframework.http.HttpStatus.OK);
	}

}
