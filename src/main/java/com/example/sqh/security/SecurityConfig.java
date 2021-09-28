package com.example.sqh.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

  private static final String[] SWAGGER = {
          "/v2/api-docs",
          "/configuration/ui",
          "/swagger-resources/**",
          "/configuration/security/**",
          "/swagger-ui/*",
          "/webjars/**",
          "/api/v1/inst-exam-mark-policy/**",
          "/h2/**"
  };

  @Override
  protected void configure(HttpSecurity http) throws Exception {
//    http
//            .cors().and()
//            .csrf().disable()
//            .authorizeRequests()
//            .antMatchers(HttpMethod.POST, "/h2/login.jsp").permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.cors().and().csrf().disable().authorizeRequests().antMatchers(SWAGGER).permitAll().anyRequest().permitAll();
//
//    http.authorizeRequests()
//            .antMatchers("/").permitAll()
//            .antMatchers("/h2/**").permitAll();

    http.headers().frameOptions().disable();
  }
}
