package com.epam.jwt.auth.server.controller;

import com.epam.jwt.auth.server.exception.BadCredentialException;
import com.epam.jwt.auth.server.model.AuthRequest;
import com.epam.jwt.auth.server.model.AuthResponse;
import com.epam.jwt.auth.server.util.SecurityUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Security controller.
 */
@RestController
public class SecurityController {

    private final SecurityUtils securityUtils;
    private final AuthenticationManager authenticationManager;

    /**
     * Instantiates a new Security controller.
     *
     * @param jwtUtil               the jwt util
     * @param authenticationManager the authentication manager
     */
    public SecurityController(final SecurityUtils jwtUtil,
                              final AuthenticationManager authenticationManager) {
        this.securityUtils = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/")
    public String welcome(){
        return "Welcome to JWT Auth";
    }


    /**
     * Generate token auth response.
     *
     * @param authRequest the auth request
     * @return the auth response
     * @throws BadCredentialException the bad credential exception
     */
    @PostMapping("/authenticate")
    public AuthResponse generateToken(@RequestBody final AuthRequest authRequest) throws BadCredentialException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new BadCredentialException("Invalid username/password");
        }
        return new AuthResponse(securityUtils.generateToken(authRequest.getUserName()));
    }
}
