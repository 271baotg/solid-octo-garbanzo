package com.example.jpasample.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurity {


    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}1340")
                .roles("ADMIN")
                .build();

        UserDetails staff = User.builder()
                .username("staff")
                .password("{noop}1340")
                .roles("STAFF")
                .build();

        return new InMemoryUserDetailsManager(admin,staff);
    }
}
