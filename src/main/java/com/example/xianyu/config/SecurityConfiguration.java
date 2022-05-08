package com.example.xianyu.config;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Resource
//    UserAuthServiceImpl service;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers().permitAll()
//                .anyRequest().hasRole("user")
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("")
//                .defaultSuccessUrl("/index",true)
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login")
//                .and()
//                .csrf().disable();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(service)
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }
}
