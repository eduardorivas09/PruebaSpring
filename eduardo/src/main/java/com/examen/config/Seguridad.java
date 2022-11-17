package com.examen.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class Seguridad {

    @Value("${usrr2}")
    String usuario2;

    @Value("${paswr2}")
    String clave2;

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username(usuario2)
                .password(clave2)
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
            return security
                    .csrf()
                    .disable()
                    .authorizeRequests()
                    .antMatchers("/Aerolinea/**")
                    .authenticated()
                    .and()
                    .httpBasic(Customizer.withDefaults())
                    .build();

    }

}
