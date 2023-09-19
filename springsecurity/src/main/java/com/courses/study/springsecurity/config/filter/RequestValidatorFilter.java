package com.courses.study.springsecurity.config.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.manager.Constants;
import org.apache.tomcat.util.digester.DocumentProperties;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class RequestValidatorFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest rq = (HttpServletRequest) request;
        HttpServletResponse rs = (HttpServletResponse) response;
        String header = rq.getHeader("AUTHORIZATION");

        byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);
        byte[] decoded;
        decoded = Base64.getDecoder().decode(base64Token);
        String token = new String(decoded, StandardCharsets.UTF_8);
        String user = token.substring(0, token.indexOf(":"));
        if (user.equalsIgnoreCase("ramon")) {
            rs.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        filterChain.doFilter(request, response);
    }
}
