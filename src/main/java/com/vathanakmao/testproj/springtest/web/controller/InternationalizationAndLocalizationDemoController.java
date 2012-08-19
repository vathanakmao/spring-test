package com.vathanakmao.testproj.springtest.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

import com.vathanakmao.testproj.springtest.util.Console;

@Controller
@RequestMapping(value = "/i18ndemo/*")
public class InternationalizationAndLocalizationDemoController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String handleRequest(Model model, HttpServletRequest request, HttpServletResponse response) {

        Console.print("language = " + request.getLocale().getLanguage() + ", display name = "
                + request.getLocale().getDisplayName());

        RequestContext requestContext = new RequestContext(request);
        String msg = requestContext.getMessage("message.greeting");

        model.addAttribute("greetingMessage", msg);
        return "greeting";
    }
}
