package com.keenness.common.util.jwt;

import com.keenness.common.util.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author cj
 * @create 2018-01-18 10:38
 **/
public class JWTHelper {

    static final long EXPIRATIONTIME = 864_000_000; // 10 days
    public static final String JWT_KEY_USER_ID = "userId";
    public static final String JWT_KEY_NAME = "name";
    static final String SECRET = "XXxLCcFHHh";

    public static String createJWT(JWTInfo jwtInfo){
        String token = Jwts.builder()
                .setSubject(jwtInfo.getUserName())
                .claim(JWT_KEY_USER_ID,jwtInfo.getUserId())
                .claim(JWT_KEY_NAME,jwtInfo.getName())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return token;
    }

    public static Claims parseJWT(String token,String base64Security){
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }

    public static JWTInfo parseJWTInfo(String token){
        Claims claims = parseJWT(token,SECRET);
        JWTInfo jwtInfo = new JWTInfo(claims.getSubject(), StringUtils.getObjectValue(claims.get("userId")),StringUtils.getObjectValue(claims.get("name")));
        return jwtInfo;
    }
}
