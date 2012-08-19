package com.vathanakmao.testproj.springtest.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebUtil {
    private static final Logger log = LoggerFactory.getLogger(WebUtil.class);

    public static void redirect(String url, HttpServletResponse response) {
        try {
            response.sendRedirect(url);
        }
        catch (IOException e) {
            log.debug("Unabled to redirect to " + url, e);
        }
    }

    public static void forward(String url, HttpServletRequest aRequest, HttpServletResponse aResponse) {
        RequestDispatcher dispatcher = aRequest.getRequestDispatcher(url);
        try {
            dispatcher.forward(aRequest, aResponse);
        }
        catch (Exception e) {
            log.debug("Unabled to forward to " + url, e);
        }
    }

    public static Long getLongParam(String name, HttpServletRequest request) {
        String param = request.getParameter(name);
        return Long.parseLong(param);
    }
}
