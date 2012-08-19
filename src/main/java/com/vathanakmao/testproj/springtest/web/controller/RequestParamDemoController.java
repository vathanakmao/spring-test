package com.vathanakmao.testproj.springtest.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vathanakmao.testproj.springtest.service.EmployeeService;

@Controller
@RequestMapping(value = "/requestparamdemo/")
public class RequestParamDemoController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * To test it, access "employee?id=1", for example.
     * 
     * @param employees
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "employee")
    public String getEmployee(@RequestParam("id") Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployee(id));
        return "employee";
    }

}
