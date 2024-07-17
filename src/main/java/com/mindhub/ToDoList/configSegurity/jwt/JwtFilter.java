package com.mindhub.ToDoList.configSegurity.jwt;

import com.mindhub.ToDoList.configSegurity.ClientDetailsService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private ClientDetailsService clientDetailsService;
    Claims claims;
    private String username = null;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, IOException, ServletException {
        try{
            if(request.getServletPath().matches("/api/auth/signup|/api/auth/test|/api/auth/login") || request.getServletPath().startsWith("/h2-console")){
                filterChain.doFilter(request, response);
            } else {
                String authorizationHeader = request.getHeader("Authorization");
                String token = null;
                if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
                    token = authorizationHeader.substring(7);
                    claims = jwtUtils.getAllClaimsFromToken(token);
                    username = claims.getSubject();
                }
                if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                    UserDetails userDetails = clientDetailsService.loadUserByUsername(username);
                    if(jwtUtils.validateToken(token, userDetails)){
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        new WebAuthenticationDetailsSource().buildDetails(request);
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                }

            }
        } catch (Exception e){
            System.out.println("Excepcion: " + e);
            response.sendError(403);
        }
        finally {
            filterChain.doFilter(request, response);
        }
    }
    public boolean isAdmin(){
        return claims.get("role").equals("ADMIN");
    }

    public boolean isClient(){
        return claims.get("role").equals("CLIENT");
    }

    public String getCurrentUser(){
        return username;
    }
}
