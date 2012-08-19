package com.vathanakmao.testproj.springtest.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestTimeTrackerInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(RequestTimeTrackerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Date startTime = new Date();

        log.info("Request start time: " + startTime);

        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {

        Date startTime = (Date) request.getAttribute("startTime");
        Date endTime = new Date();
        request.setAttribute("endTime", endTime);

        long diffTimeInMillis = endTime.getTime() - startTime.getTime();
        request.setAttribute("handlingTime", (double) diffTimeInMillis / 1000);

        log.info("Request end time: " + endTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
