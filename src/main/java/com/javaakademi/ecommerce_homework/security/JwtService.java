package com.javaakademi.ecommerce_homework.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public class JwtService {
    private String jwtSecret = "very_secret_key"; // secret key
    private int jwtExpirationMs = 86400000; // 24 saatlik exp süresi

    public String generateJwtToken(Authentication authentication) {
        // Authentication nesnesinden giriş yapan kullanıcının bilgilerini alır.
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        // JWT oluşturma süreci:
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername()) // Token'ın 'subject' alanına kullanıcının kullanıcı adını koyar.
                .setIssuedAt(new Date()) // Token'ın oluşturulma zamanını belirtir.
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                // Token'ın geçerlilik süresini belirler. Bu örnekte, 24 saatlik bir süre kullanılmıştır.
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                // Token'ın imzalanmasını sağlar. HS512 algoritması kullanılarak imzalanır.
                .compact(); // JWT token'ı bir String olarak oluşturur.
    }


    public boolean validateJwtToken(String authToken) {
        try {
            // Token'ı analiz ediyoruz ve doğruluğunu kontrol ediyoruz.
            Jwts.parser()
                    .setSigningKey(jwtSecret)  // Token'ı imzalarken kullanılan gizli anahtar burada belirlenir.
                    .parseClaimsJws(authToken); // Token'ın yapısını (header, payload, signature) kontrol eder ve doğrular.
            // Eğer bir hata oluşmazsa, token geçerlidir.
            return true;
        } catch (JwtException e) {
            // Eğer bir hata yakalanırsa, bu token'ın geçersiz olduğunu gösterir.
            return false;
        }
    }

}

