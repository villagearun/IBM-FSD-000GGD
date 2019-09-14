package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoConfigSecurity extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception
	{ 
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("arun").password("123").roles("Employee"))
		.withUser(users.username("karthik").password("123").roles("Manager"))
		.withUser(users.username("mani").password("123").roles("Admin"));
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	    http.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		    .formLogin()
		    .loginPage("/showMyLoginPage")
		    .loginProcessingUrl("/authenticateTheUser")
		    .permitAll()
		    .and()
		    .logout().permitAll();
	}
	
}

