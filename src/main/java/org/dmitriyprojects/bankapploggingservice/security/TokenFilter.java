package org.dmitriyprojects.bankapploggingservice.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dmitriyprojects.bankapploggingservice.db.h2.TokenService;
import org.dmitriyprojects.bankapploggingservice.db.h2.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Component
public class TokenFilter extends OncePerRequestFilter {
    @Autowired
    TokenService tokenService;
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Cookie[] userCookies = request.getCookies();
        if(userCookies == null) {
            filterChain.doFilter(request, response);
            return;
        }
        Optional<Cookie> userCookie = Arrays.stream(userCookies).filter(cookie -> cookie.getName().equals("JwtAdmin")).findFirst();
        if(userCookie.isEmpty()) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = userCookie.get().getValue();

        if(!tokenService.verifyToken(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        String username = tokenService.extractUsername(token);
        UserDetails currentUser = userDetailsService.loadUserByUsername(username);
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(new UsernamePasswordAuthenticationToken(currentUser, null, currentUser.getAuthorities()));
        SecurityContextHolder.setContext(context);

        filterChain.doFilter(request,response);
    }
}
