/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto;

import com.proyecto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author owenm
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userDetailsService;

    @Bean
    public BCryptPasswordEncoder PasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserService getUserService() {
        return new UserService();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(PasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(getUserService());
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler() {
        return new AppAuthenticationSuccessHandler();
    }

    public SecurityConfig(UserService userPrincipalDetailsService) {
        this.userDetailsService = userPrincipalDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    // Para autenticar al usuario
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/home", "/salonCita", "/salonAgendar", "/save", "/editCita/{id}", "/delete/{id}")
                .hasRole("ADMIN") //admin solo ve las citas y su manejo

                .antMatchers("/login", "/home", "/", "/salonServicios", "/salonProductos", "/salonPromociones",
                        "/salonAgendar", "/salonContacto", "/save", "/salonEnviado")
                .hasAnyRole("USER", "ADMIN") //Usuarios acceden a todo menos citas agendadas 

                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll().defaultSuccessUrl("/home", true);
    }

             /* http.authorizeRequests()
                 http.csrf().disable();
                 http.headers().frameoptions().disable;
    
    .            antMatchers("/login","/home","/salonCita","/salonAgendar","/save","/editCita/{id}","/delete/{id}")
                .hasRole("ADMIN") //admin solo ve las citas y su manejo
                
                .antMatchers("/login","/home", "/","/salonServicios","/salonProductos","/salonPromociones",
                        "/salonAgendar", "/salonContacto","/save")
                .hasRole("USER") //Usuarios acceden a todo menos citas agendadas 
                
                .anyRquest().authenticated()
                 and()
                .formLogin()
                .loginPage("/login").permitAll().defaultSuccessUrl("/home", true);
    
    otro intento
                http
			.csrf().disable()
			.authorizeRequests().antMatchers("/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/home", true);
	}
    
     */
}
