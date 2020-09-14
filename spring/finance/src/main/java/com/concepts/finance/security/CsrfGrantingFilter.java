package com.concepts.finance.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;

public class CsrfGrantingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        CsrfToken csrf = (CsrfToken) servletRequest.getAttribute(CsrfToken.class.getName());
        String token = csrf.getToken();
        System.out.println("token: " + token);
        if (token != null && isAuthenticating(servletRequest)) {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            Cookie cookie = new Cookie("CSRF-TOKEN", token);
            cookie.setPath("/");
            System.out.println(cookie);
            response.addCookie(cookie);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isAuthenticating(ServletRequest servletRequest) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("URI: " + request.getRequestURI());
        return request.getRequestURI().equals("/clu/fin/start-session");
    }

    @Override
    public void destroy() {
    }

}
