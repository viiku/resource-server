package com.vikku.ResourceServer.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Bean
    SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

////        configure Http Security
////        All incoming http request must come from user who have authenticated themselves
////        application will expect incoming requests to have special kind of token known as jwt
        httpSecurity.authorizeHttpRequests(authz ->
                        authz.requestMatchers(HttpMethod.GET, "/users/status/check")
//                                .hasAuthority("SCOPE_profile")
                                .hasRole("developer")
//                                .hasAnyRole("developer", "user")
                                .anyRequest().authenticated())
                .and()
                .oauth
//                .oauth2ResourceServer(oauth2 ->
//                        oauth2.jwt(jwt ->{}));

        return httpSecurity.build();
    }
}
