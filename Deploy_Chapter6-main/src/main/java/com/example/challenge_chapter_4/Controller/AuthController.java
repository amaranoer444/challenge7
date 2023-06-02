package com.example.challenge_chapter_4.Controller;

import com.example.challenge_chapter_4.Service.JwtService;
import com.example.challenge_chapter_4.Service.UsersService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value ="/Auth")
@Api(value = "Authentication")
public class AuthController {
    @Autowired
    UsersService us;
    @Autowired
    public JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    private AuthRequest authRequest;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping(value = "/Authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){
        this.authRequest = authRequest;
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return String.valueOf(jwtService.generateToken(authRequest.getUsername()));
        }
        else {
            throw new UsernameNotFoundException("Invalid user resquest !");
        }

    }
}
