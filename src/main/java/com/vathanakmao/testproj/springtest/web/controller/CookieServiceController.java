package com.vathanakmao.testproj.springtest.web.controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vathanakmao.testproj.springtest.util.Console;

@Controller
@RequestMapping("/cookieservice")
public class CookieServiceController {

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public void showCookies(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletOutputStream out = response.getOutputStream();

        for(Cookie cookie : request.getCookies()) {
            String c = "Cookie - name = " + cookie.getName() + ", value = " + cookie.getValue() + "<br/>";
            out.write(c.getBytes());

            Console.print(c);
        }

        out.close();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void addCookies(@RequestParam("name") String name, @RequestParam("value") String value, HttpServletResponse response)
            throws IOException {

        response.addCookie(new Cookie(name, value));

        ServletOutputStream out = response.getOutputStream();
        out.write("SUCCESS".getBytes());
        out.close();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void deleteCookie(@RequestParam("name") String name, HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        for(Cookie cookie : request.getCookies()) {
            Console.print("Cookie [name = " + cookie.getName() + "]");

            if (cookie.getName().equals(name)) {
                Console.print("Found cookie named " + name);

                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

        ServletOutputStream out = response.getOutputStream();
        out.write("SUCCESS".getBytes());
        out.close();
    }

}
