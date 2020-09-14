package com.concepts.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.concepts.finance.security.CsrfGrantingFilter;
import com.concepts.finance.security.CustomAuthenticationProvider;
import com.concepts.finance.security.JwtVerificationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    String[] patterns = new String[] { "/start-session", "/login", "/bower_components/**/*",
            "/app/**/*", "/index.html", "/home.html", "/signin.html", "/favicon.ico" };
    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().disable();
        httpSecurity.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("/check-csrf"));

        // Form Login Security Configuration - If a login page is not specified then a default login
        // page is presented. Although for REST only application this is not applicable.
        // httpSecurity.authorizeRequests().antMatchers("/**").hasRole("user").and().formLogin()
        // .loginPage("").loginProcessingUrl("").defaultSuccessUrl("");

        // Following is the configuration for basic authentication using username and password.
        // A typical request looks like -
        // GET /clu/fin/hello HTTP/1.1
        // Host: localhost:8080
        // Authorization: Basic dXNlcjE6cGFzcw==
        // User-Agent: curl/7.60.0
        // Accept: */*
        // over here the Authorization header contains "Basic " + Base64(username + : +
        // password)
        httpSecurity.authorizeRequests().anyRequest().authenticated().and().httpBasic().and()
                .addFilterAfter(new CsrfGrantingFilter(), SessionManagementFilter.class);

        httpSecurity.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("admin").roles("USER", "ADMIN");
        auth.authenticationProvider(authProvider);
    }

    @Bean
    public FilterRegistrationBean<JwtVerificationFilter> loggingFilter() {
        FilterRegistrationBean<JwtVerificationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtVerificationFilter());
        registrationBean.addUrlPatterns("/hello");
        registrationBean.addUrlPatterns("/check-csrf");
        return registrationBean;
    }

}
