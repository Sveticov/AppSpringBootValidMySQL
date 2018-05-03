package com.sveticov.appjstl.security;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()

                .csrf()
                .disable()

                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }


//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
////        UserDetails userDetails=
////                User.withDefaultPasswordEncoder()
////                .username("user")
////                .password("pas")
////                .roles("USER")
////                .build();
//        InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
//        manager.createUser(
//                User.withUsername("user").password("pas").roles("USER")
//                .build()
//        );
//        return manager;// new InMemoryUserDetailsManager(userDetails);
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder manager) throws Exception {
        manager.inMemoryAuthentication().withUser("fox").password("{noop}100").roles("USER");

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/webapp/**", "/js/**", "/images/**");
    }
}
