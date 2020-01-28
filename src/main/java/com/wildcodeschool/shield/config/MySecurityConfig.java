package com.wildcodeschool.shield.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/avengers/assemble/**").hasRole("avenger")
		.antMatchers("/secret-bases/**").hasRole("base")
		.antMatchers("/error/**").permitAll()
		.antMatchers("/").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()          
		.and()
		.httpBasic()
		.and()
        .logout()
        .logoutSuccessUrl("/")
        .deleteCookies("JSESSIONID");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("password").roles("");
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser("Steve").password(encoder.encode("Guy")).roles("user").and()
		.withUser("Tony").password(encoder.encode("Stark")).roles("avenger").and()
		.withUser("Nick").password(encoder.encode("Fury")).roles("base");

	}
}