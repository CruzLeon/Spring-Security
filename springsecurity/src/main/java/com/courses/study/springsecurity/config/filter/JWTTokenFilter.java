package com.courses.study.springsecurity.config.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class JWTTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.err.println("JWTTokenFilter");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            SecretKey key = Keys.hmacShaKeyFor("fNNEf1vl8W9UIqOokqEIoH7pqpbOw6zsqEKn2QSvD+j5kzxZSdoJb+/u87z6WHat/ffj0hdiyoZQJD1evqHKkQ==".getBytes(StandardCharsets.UTF_8));
            String jwt =
                    Jwts.builder()
                            .setIssuer("LOCAL")
                            .setSubject("token")
                            .claim("username", authentication.getName())
                            .claim("authorities", authentication.getAuthorities())
                            .setIssuedAt(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)))
                            .signWith(key).compact();
            response.setHeader("Authorization", jwt);
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().equalsIgnoreCase("/user");
    }
}
