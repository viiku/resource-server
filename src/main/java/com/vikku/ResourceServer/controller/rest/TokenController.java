package com.vikku.ResourceServer.controller.rest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/token")
public class TokenController {

    @GetMapping
//    public Jwt getToken(@AuthenticationPrincipal Jwt jwt) {
    public Map<String, Object> getToken(@AuthenticationPrincipal Jwt jwt) {
//        return jwt.getTokenValue();
//        return jwt;
        return Collections.singletonMap("principal", jwt);
    }
}
