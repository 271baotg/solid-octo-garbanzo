package com.example.jpasample.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurity {

//    Setting up JDBC authentication with the credentials table inside DB

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }


//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}1340")
//                .roles("admin")
//                .build();
//
//        UserDetails staff = User.builder()
//                .username("staff")
//                .password("{noop}1340")
//                .roles("staff")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin,staff);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.authorizeHttpRequests( configure ->
                configure
                        .requestMatchers(HttpMethod.GET,"/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/employees/**").hasRole("ADMIN")
        );
        httpSecurity.httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }
}
