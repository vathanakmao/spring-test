package com.vathanakmao.testproj.springtest.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vathanakmao.testproj.springtest.model.Employee;
import com.vathanakmao.testproj.springtest.util.Console;

@Controller
@RequestMapping(value = "/modelattributedemo/*")
public class ModelAttributeDemoController {

	@ModelAttribute("employees")
	public ArrayList<Employee> populateEmployee() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1L, "Sok San"));
		employees.add(new Employee(2L, "Sen Sok"));
		return employees;
	}

	/**
	 * To test it, access "employee?id=1", for example.
	 * 
	 * @param employees
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "employee")
	public String getEmployee(
			@ModelAttribute("employees") ArrayList<Employee> employees,
			Model model, HttpServletRequest request) {
		String id = request.getParameter("id");

		for (Employee emp : employees) {
			Console.print("Employee [id = " + emp.getId() + ", name = "
					+ emp.getName() + "]");

			if (emp.getId().toString().equals(id)) {
				model.addAttribute("employee", emp);
			}
		}

		return "employee";
	}

	/**
	 * Uses the "employee/addForm" api to test this api.
	 * 
	 * @param employee
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "employee/add")
	public void addEmployee(@ModelAttribute("employee") Employee employee,
			HttpServletResponse response) throws IOException {
		response.getWriter().print(
				"The employee " + employee.getName()
						+ " has been added with the generated ID 1.");
	}

	@RequestMapping(value = "employee/addform")
	public String formAddEmployee(Model model) {
		model.addAttribute("submitUrl",
				"/spring-test/modelattribute/employee/add");
		return "addEmployee";
	}

}
