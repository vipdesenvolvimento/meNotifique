package com.dev.vip.menotifique.config;


import com.dev.vip.menotifique.provider.CustomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomProvider authProvider;
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable().authorizeRequests().anyRequest().permitAll();
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .anonymous().disable().exceptionHandling()
////                .and()
////                .authorizeRequests()
////                .antMatchers("/**")
////                .permitAll()
//                .and()
//                .httpBasic()
//                .authenticationEntryPoint((request, response, e) ->
//                {
//                    response.setContentType("application/json;charset=UTF-8");
//                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                    response.getWriter().write("{\"status\":401,\"message\":\"Sem permissão\"}");
//                });
    }



}
