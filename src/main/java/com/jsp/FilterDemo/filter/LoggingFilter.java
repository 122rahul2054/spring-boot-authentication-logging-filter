package com.jsp.FilterDemo.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain)
            throws IOException, ServletException {

        // Convert ServletRequest to HttpServletRequest
        HttpServletRequest httpServletRequest =
                (HttpServletRequest) servletRequest;

        // Convert ServletResponse to HttpServletResponse
        HttpServletResponse httpServletResponse =
                (HttpServletResponse) servletResponse;

        // Generate unique Request ID
        String requestId = UUID.randomUUID().toString();

        // Add Request ID to Response Header
        httpServletResponse.setHeader(
                "X-Request-Id",
                requestId
        );

        // =====================================
        // START TIME
        // =====================================

        long startTime = System.currentTimeMillis();

        // =====================================
        // REQUEST LOG
        // =====================================

        System.out.println(
                "Incoming Request: "
                        + httpServletRequest.getMethod()
                        + " "
                        + httpServletRequest.getRequestURI()
        );

        System.out.println(
                "Request ID: " + requestId
        );

        // =====================================
        // PASS REQUEST TO CONTROLLER
        // =====================================

        filterChain.doFilter(
                servletRequest,
                servletResponse
        );

        // =====================================
        // END TIME
        // =====================================

        long endTime = System.currentTimeMillis();

        // Calculate response time
        long responseTime = endTime - startTime;

        // =====================================
        // RESPONSE LOG
        // =====================================

        System.out.println(
                "Response Status: "
                        + httpServletResponse.getStatus()
        );

        System.out.println(
                "Response Time: "
                        + responseTime
                        + " ms"
        );

        System.out.println(
                "Request ID: " + requestId
        );
    }
}