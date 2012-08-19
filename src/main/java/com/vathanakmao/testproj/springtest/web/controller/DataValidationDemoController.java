package com.vathanakmao.testproj.springtest.web.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vathanakmao.testproj.springtest.model.Book;
import com.vathanakmao.testproj.springtest.util.BindingResultParser;

/**
 * 1. Required libs: javax.validation.validation-api.jar and org.hibernate.hibernate-validator.jar
 * 2. Declare <mvc:annotation-driven/> tag in the context file
 * 3. Annotate @Valid annotation on the parameter object to be validated.
 * 
 * @author vathanak
 *
 */
@Controller
@RequestMapping(value = "/datavalidationdemo")
public class DataValidationDemoController {

    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public ResponseEntity<?> addEmployee(@Valid Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<ArrayList<String>>(BindingResultParser.toListOfStrings(bindingResult),
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/book/addform", method = RequestMethod.GET)
    public String addEmployeeForm(Model model) {
        model.addAttribute("submitUrl", "/spring-test/datavalidationdemo/book/add");

        return "addBook";
    }

}
