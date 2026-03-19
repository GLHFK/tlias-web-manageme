package com.example.tliaswebmanageme.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;

@Slf4j
public class JWTUtils {
    private static final String code = "LIUHUA";
    private static final long EXPIRE = 1000 * 60 * 60 * 24;//24小时

    public static String creatJWT(Map<String, Object> datamap) {
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, code)
                .addClaims(datamap)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .compact();
    }

    public static Claims parseJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(code)
                .parseClaimsJws(token)
                .getBody();
        log.info(claims.toString());
        return claims;
    }
}
