package cn.moonify;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;
import com.auth0.jwt.JWT;
import java.util.Date;

public class JwtTest {

    @Test
    public void testGen(){
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("张三","123456");
        claims.put("李四","654321");

        String jwtString = JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .sign(Algorithm.HMAC256("moonify"));
        System.out.println(jwtString);
    }
    @Test
    public void testVerify() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7IuadjuWbmyI6IjY1NDMyMSIsIuW8oOS4iSI6IjEyMzQ1NiJ9LCJleHAiOjE3NDc4MDQyNDJ9" +
                ".Y-h8Bl3iIMGarMRhcwUhEhYyCjBod_oKml5Iszw32iE";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("moonify")).build();

        try {
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            Map<String, Claim> claims = decodedJWT.getClaims();
            System.out.println(claims.get("user"));
        } catch (JWTVerificationException e) {
            // 令牌验证未通过
            System.out.println("令牌验证未通过");
        }

    }
}
