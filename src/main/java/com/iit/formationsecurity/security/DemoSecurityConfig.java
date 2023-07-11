package com.iit.formationsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.security.Security;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/formations/**").hasRole("ETUDIANT")
                        .requestMatchers(HttpMethod.POST, "/formations").hasRole("ENSEIGNANT")
                        .requestMatchers(HttpMethod.PUT, "/formations/**").hasRole("ENSEIGNANT")
                        .requestMatchers(HttpMethod.DELETE, "/formations/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/tPs/**").hasRole("ETUDIANT")
                        .requestMatchers(HttpMethod.POST, "/tPs").hasRole("ENSEIGNANT")
                        .requestMatchers(HttpMethod.PUT, "/tPs/**").hasRole("ENSEIGNANT")
                        .requestMatchers(HttpMethod.DELETE, "/tPs/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/tpCorrections/**").hasRole("ETUDIANT")
                        .requestMatchers(HttpMethod.POST, "/tpCorrections").hasRole("ENSEIGNANT")
                        .requestMatchers(HttpMethod.PUT, "/tpCorrections/**").hasRole("ENSEIGNANT")
                        .requestMatchers(HttpMethod.DELETE, "/tpCorrections/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/formationDetails/**").hasRole("ETUDIANT")
                        .requestMatchers(HttpMethod.POST, "/formationDetails").hasRole("ENSEIGNANT")
                        .requestMatchers(HttpMethod.PUT, "/formationDetails/**").hasRole("ENSEIGNANT")
                        .requestMatchers(HttpMethod.DELETE, "/formationDetails/**").hasRole("ADMIN")
        );

        http.httpBasic();

        http.csrf().disable();

        return http.build();
    }
}
