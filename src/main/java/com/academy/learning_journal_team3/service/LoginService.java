package com.academy.learning_journal_team3.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


    public boolean authentication(String email, String password) {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);

            Authentication authentication = authenticationManager.authenticate(token);

            // Erfolgreiche Authentifizierung - den Authentication-Token im SecurityContext speichern
            SecurityContextHolder.getContext().setAuthentication(authentication);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
