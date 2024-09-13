package ru.alyoshka.hibernatedao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import ru.alyoshka.hibernatedao.model.Roles;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    private final String ADMIN_ROLE = Roles.ADMIN.name();
    private final String MODERATOR_ROLE = Roles.MODERATOR.name();
    private final String USER_ROLE = Roles.USER.name();

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("ADMIN")
                .password(passwordEncoder().encode("admin"))
                .roles(ADMIN_ROLE)
                .build();
        UserDetails moderator = User.withUsername("MODERATOR")
                .password(passwordEncoder().encode("moderator"))
                .roles(MODERATOR_ROLE)
                .build();
        UserDetails user = User.withUsername("USER")
                .password(passwordEncoder().encode("user"))
                .roles(USER_ROLE)
                .build();

        return new InMemoryUserDetailsManager(admin, moderator, user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.formLogin(Customizer.withDefaults())
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(HttpMethod.GET, "/persons/hello").permitAll()
                        .requestMatchers(HttpMethod.GET, "/persons/find-by-name-and-surname/**").hasAnyRole(ADMIN_ROLE)
                        .requestMatchers(HttpMethod.GET, "/persons/find-by-city/**").hasAnyRole(ADMIN_ROLE, MODERATOR_ROLE)
                        .requestMatchers(HttpMethod.GET, "/persons/by-age-less/**").hasAnyRole(ADMIN_ROLE, MODERATOR_ROLE, USER_ROLE))
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
