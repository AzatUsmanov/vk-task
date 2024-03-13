package pet.projects.vktask.security;

import jakarta.servlet.Filter;

import lombok.AllArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    private final AccessDeniedHandler accessDeniedHandler;

    private final AuthenticationFailureHandler authenticationFailureHandler;

    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    private final Filter filter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(authorizeHttpRequests -> {
                authorizeHttpRequests
                        .requestMatchers(HttpMethod.POST, "/api/registration").permitAll()


                        .requestMatchers(HttpMethod.POST, "/api/posts/**")
                        .hasAnyAuthority("ROLE_ADMIN", "ROLE_POSTS_EDITOR")

                        .requestMatchers(HttpMethod.PUT, "/api/posts/**")
                        .hasAnyAuthority("ROLE_ADMIN", "ROLE_POSTS_EDITOR")

                        .requestMatchers(HttpMethod.DELETE, "/api/posts/**")
                        .hasAnyAuthority("ROLE_ADMIN", "ROLE_POSTS_EDITOR")

                        .requestMatchers(HttpMethod.GET, "/api/posts/**")
                        .hasAnyAuthority("ROLE_ADMIN", "ROLE_POSTS_VIEWER")


                        .requestMatchers(HttpMethod.POST, "/api/albums/**")
                        .hasAnyAuthority("ROLE_ADMIN", "ROLE_ALBUMS_EDITOR")

                        .requestMatchers(HttpMethod.PUT, "/api/albums/**")
                        .hasAnyAuthority("ROLE_ADMIN", "ROLE_ALBUMS_EDITOR")

                        .requestMatchers(HttpMethod.DELETE, "/api/albums/**")
                        .hasAnyAuthority("ROLE_ADMIN", "ROLE_ALBUMS_EDITOR")

                        .requestMatchers(HttpMethod.GET, "/api/albums/**")
                        .hasAnyAuthority("ROLE_ADMIN", "ROLE_ALBUMS_VIEWER")


                        .requestMatchers(HttpMethod.POST, "/api/users/**")
                        .hasAnyAuthority("ROLE_ADMIN", "ROLE_USERS_EDITOR")

                        .requestMatchers(HttpMethod.PUT, "/api/users/**")
                        .hasAnyAuthority("ROLE_ADMIN", "ROLE_USERS_EDITOR")

                        .requestMatchers(HttpMethod.DELETE, "/api/users/**")
                        .hasAnyAuthority("ROLE_ADMIN", "ROLE_USERS_EDITOR")

                        .requestMatchers(HttpMethod.GET, "/api/users/**")
                        .hasAnyAuthority("ROLE_ADMIN", "ROLE_USERS_VIEWER")


                        .anyRequest().authenticated();
            })
                .addFilterAfter(filter, AuthorizationFilter.class)
                .formLogin(form ->
                            form
                                    .successHandler(authenticationSuccessHandler)
                                    .failureHandler(authenticationFailureHandler))
                .exceptionHandling(ex ->
                            ex.accessDeniedHandler(accessDeniedHandler))
                .authenticationProvider(authenticationProvider())
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        final var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
