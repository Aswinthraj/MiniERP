package com.raj.springweb.config;

import com.raj.springweb.util.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI();

        // Allow public endpoints
        if ( path.startsWith("/auth") || path.equals("/") ||  path.equals("/login") || path.equals("/register")
                || path.contains("swagger") || path.contains("api-docs")) {
            chain.doFilter(request, response);
            return;
        }

        // Get token
        String authHeader = req.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("Missing or Invalid token");
            return;
        }

        String token = authHeader.substring(7);

        // Validate token
        if (!JwtUtil.validateToken(token)) {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("Invalid token");
            return;
        }

        // Extract role BEFORE allowing request
        String role = JwtUtil.extractRole(token);

        // Role-based restriction
        if (path.startsWith("/business")) {
            String method = req.getMethod();

            if (!"ADMIN".equals(role) &&
                    (method.equals("DELETE") || method.equals("PUT") || method.equals("POST"))) {

                res.setStatus(HttpServletResponse.SC_FORBIDDEN);
                res.getWriter().write("Access denied: ADMIN only");
                return;
            }
        }

        // Finally allow request
        chain.doFilter(request, response);
    }
}



