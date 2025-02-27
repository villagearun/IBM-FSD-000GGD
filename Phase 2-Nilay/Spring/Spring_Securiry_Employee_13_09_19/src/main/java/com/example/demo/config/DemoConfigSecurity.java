package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
		.withUser(users.username("arun").password("arun123").roles("Employee"))
		.withUser(users.username("karthik").password("karthik123").roles("Employee","Manager"))
		.withUser(users.username("mani").password("mani123").roles("Employee","Admin"));
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").hasRole("Employee")
		.antMatchers("/leaders/**").hasRole("Manager")
		.antMatchers("/systems/**").hasRole("Admin")
		.and().formLogin().permitAll()
		.and()		
		.logout().permitAll();    
		    
	}
	@Override
	public void configure(WebSecurity Web) throws Exception 
	{
		Web.ignoring().antMatchers("/h2-console/**");
	}
	
}

