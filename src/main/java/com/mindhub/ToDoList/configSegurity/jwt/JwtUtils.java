package com.mindhub.ToDoList.configSegurity.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Service
public class JwtUtils {

    private final SecretKey key = Jwts.SIG.HS256.key().build();
    public String getUsernameFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }
    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    public Claims getAllClaimsFromToken(String token){
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
    }
    private boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    public String generateToken(String username, String role){
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        return createToken(claims, username);
    }
    private String createToken(Map<String, Object> claims, String subject){
        return Jwts.builder().claims(claims).subject(subject).issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 100 * 60 * 60 * 10))
                .signWith(key).compact();
    }
    public boolean validateToken(String token, UserDetails userDetails){
        final String tokenUsername = getUsernameFromToken(token);
        return (tokenUsername.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
