package com.vathanakmao.testproj.springtest.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Vathanak Mao
 * @since 2012-01-04
 */
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 2342835236601952818L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.write("Hello World!".getBytes());
        out.flush();
        out.close();
    }

}
