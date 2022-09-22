package com.example.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity( prePostEnabled = true )
public class AppSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Bean
    BCryptPasswordEncoder getEncode(){
        return new BCryptPasswordEncoder() ;
    }

    @Bean
    AuthenticationProvider customAuthenticationProvider(){
        AuthenticationProvider provider = new HnUserAuthProvider() ;
        return provider ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("nguoidung")
                .password(getEncode().encode("123456"))
                .roles("USER")
                .and()
                .withUser("quantri")
                .password(getEncode().encode("123456"))
                .roles("ADMIN" , "USER");
        auth.authenticationProvider( customAuthenticationProvider() );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasRole("USER")
                .anyRequest().authenticated().and().httpBasic();
    }


}
