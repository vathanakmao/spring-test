package com.vathanakmao.testproj.springtest.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vathanakmao.testproj.springtest.service.EmployeeService;

@Controller
@RequestMapping(value = "/pathvariabledemo/*")
public class PathVariableDemoController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * To test it, access "employee/1", for example.
     * 
     * @param employees
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "employee/{id}")
    public String getEmployee(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployee(id));
        return "employee";
    }

}
