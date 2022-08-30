package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class AppSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Bean
    BCryptPasswordEncoder getPass() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth ) throws Exception {
         auth.inMemoryAuthentication().withUser("thuylm").password(getPass().encode("thuylm")).roles("USER");
     }

     @Override
    protected void configure(HttpSecurity httpSecurity ) throws Exception {
//        httpSecurity.csrf() ;

         httpSecurity.authorizeRequests()
                 .antMatchers("/").permitAll()
                 .antMatchers("/nguoi-dung/**").hasRole("USER")
                 .anyRequest().authenticated() ;

         httpSecurity.formLogin()
                 .loginPage("/login")
                 .permitAll()
                 .usernameParameter("username")
                 .passwordParameter("password")
                 .loginProcessingUrl("/login")
                 .failureUrl("/login?error")
                 .defaultSuccessUrl("/nguoi-dung");
     }
}
