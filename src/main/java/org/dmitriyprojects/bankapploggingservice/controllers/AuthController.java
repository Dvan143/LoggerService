package org.dmitriyprojects.bankapploggingservice.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dmitriyprojects.bankapploggingservice.db.h2.TokenService;
import org.dmitriyprojects.bankapploggingservice.logging.LoggerService;
import org.dmitriyprojects.bankapploggingservice.logs.WrongPasswordLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class AuthController {
    @Value("${loggingService.secret.expiration}")
    private Long expiration;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    LoggerService logger;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public void login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, HttpServletResponse resp, HttpServletRequest req) throws IOException {
        try{
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username,password);
            authenticationManager.authenticate(authToken);

            ResponseCookie cookie = ResponseCookie.from("JwtAdmin")
                    .value(tokenService.generateToken(username))
                    .httpOnly(true)
                    .path("/")
                    .maxAge(expiration*60*60*24)
                    .build();

            resp.addHeader("Set-Cookie", cookie.toString());
            resp.sendRedirect("/logsPanel");
        } catch (AuthenticationException ex) {
            WrongPasswordLog log = new WrongPasswordLog(req);
            logger.saveNewLog(log);
        }
    }
}
