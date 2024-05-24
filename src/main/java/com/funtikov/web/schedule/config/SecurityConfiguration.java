package com.funtikov.web.schedule.config;

import com.funtikov.web.schedule.entity.User;
import com.funtikov.web.schedule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDate;

@Configuration
public class SecurityConfiguration {

    private LocalDate localDate = LocalDate.now();

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(@Autowired UserRepository userRepository) throws UserPrincipalNotFoundException {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null)
                return user;

            try {
                throw new UserPrincipalNotFoundException("User " + username + " not found");
            } catch (UserPrincipalNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(requests -> requests.requestMatchers(
                        "/schedule1",
                                "/schedule2",
                                "/schedule3",
                                "/schedule4",
                                "/schedule5",
                                "/schedule6",
                                "/schedule7",
                                "/help",
                                "/logout",
                                "/settings")
                        .hasRole("USER")
                        .requestMatchers("/**","/")
                        .permitAll()
                )
                .formLogin(
                        form -> form.loginPage("/login")
                                .defaultSuccessUrl("/schedule"+localDate.getDayOfWeek().getValue())
                                .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                )
                .build();
    }


}
