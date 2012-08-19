package com.vathanakmao.testproj.springtest.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/helloworld")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    public String printHelloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        return "helloworld";
    }

}
