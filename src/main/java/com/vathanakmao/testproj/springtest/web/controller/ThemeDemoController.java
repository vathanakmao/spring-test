package com.vathanakmao.testproj.springtest.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/themedemo")
public class ThemeDemoController {

    @RequestMapping(method = RequestMethod.GET)
    public String handleRequest() {
        return "theme";
    }

}
