package com.ge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserDetailsService service;

    /*
        Customizer<CsrfConfigurer<HttpSecurity>>: This is a way to define a custom configuration for CSRF protection within the context of HTTP security.
        Customizer: You’re specifying that you want to customize something.
        CsrfConfigurer: You’re specifying that what you want to customize is the CSRF protection settings.
        HttpSecurity: You’re specifying that this customization is happening in the context of web security for HTTP requests. This means that the settings you're customizing (like CSRF protection) are specifically about how your web application handles security for users' interactions over the web.
    */

    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        Customizer<CsrfConfigurer<HttpSecurity>> configurer =  new Customizer<CsrfConfigurer<HttpSecurity>>(){
            public void customize(CsrfConfigurer<HttpSecurity> configurer){
                configurer.disable();
            }
        };
        return http.build();
    }
    */

    /*
        http.csrf(customizer -> customizer.disable()): This line is doing the same thing as the first piece of code but in a more concise way. It disables CSRF protection using a lambda expression.
        authorizeHttpRequests(request -> request.anyRequest().authenticated()): This line tells the application to require authentication for any request. Essentially, if you try to access any page, you must be logged in.
        httpBasic(Customizer.withDefaults()): This line enables basic authentication, where the browser will prompt you to enter a username and password.
        sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)): This line sets up session management to be stateless. Stateless means the server will not remember your session between requests, which is typical for APIs.
        return http.build();: This final line takes all these configurations and builds the security setup for your application.
    */

    /*
        How Lambda Expressions Work with Functional Interfaces

        Functional Interface:
        A functional interface in Java is an interface with exactly one abstract method.
        Example: Customizer<CsrfConfigurer<HttpSecurity>> has a single abstract method customize.

        Lambda Expression:
        A lambda expression provides an implementation for the abstract method of the functional interface.
        Syntax: parameter -> expression or parameter -> { statements }.

        Binding the Lambda to the Interface:
        When you write a lambda expression, Java implicitly knows which method of the functional interface it should implement based on the context.
     */

    /*
        When you assign the lambda to configurer, Java maps the lambda expression to the customize method of the Customizer interface.
        How: Java recognizes that customizer -> customizer.disable() matches the customize method because:
        The lambda has one parameter (customizer), which matches the parameter type of the customize method.
        The body of the lambda (customizer.disable()) provides the implementation for what happens inside the customize method.
     */
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        Customizer<CsrfConfigurer<HttpSecurity>> configurer = customizer->customizer.disable();
        http.csrf(configurer)
                .authorizeHttpRequests(request->request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    /*
        AuthenticationManager:
        This is a core component in Spring Security that handles authentication requests. It checks the credentials (username and password) and returns an Authentication object if the credentials are valid.
        It’s used throughout your application to perform authentication checks.

        AuthenticationConfiguration:
        This is a Spring Security class that provides access to the authentication configuration.
        It contains methods to retrieve the AuthenticationManager and other security-related configurations.

        config.getAuthenticationManager():
        This method call retrieves the configured AuthenticationManager from the AuthenticationConfiguration object.
        Essentially, it returns the AuthenticationManager that Spring Security has set up based on your application’s security configuration.
     */

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /*
        DaoAuthenticationProvider Instance:
        DaoAuthenticationProvider is a standard Spring Security provider that retrieves user details and performs authentication against a database or other data sources.

        provider.setUserDetailsService(service);
        Sets the UserDetailsService that the DaoAuthenticationProvider will use to load user-specific data.
        service is an instance of UserDetailsService (likely MyUserDetailsService in your case) which is responsible for fetching user details from the database.
        This service must implement the loadUserByUsername method to fetch user information based on a username.

        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        Sets the PasswordEncoder that the DaoAuthenticationProvider will use to encode and decode passwords.
        BCryptPasswordEncoder is used here with a strength of 12 (the "12" is a parameter that defines the strength of the hashing algorithm; higher values mean more secure but slower hashing).
        When a user tries to authenticate, this encoder is used to hash the input password and compare it with the stored hashed password in the database.
    */

    @Bean
    public AuthenticationProvider authProvider()
    {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(service);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;
    }
}
