package com.keenness.auth.util.jwt;

import com.keenness.common.util.jwt.JWTHelper;
import com.keenness.common.util.jwt.JWTInfo;
import org.springframework.stereotype.Component;

/**
 * @author cj
 * @create 2018-01-18 14:56
 **/
@Component
public class JwtTokenUtil {

    public String generateToken(JWTInfo jwtInfo){
        return JWTHelper.createJWT(jwtInfo);
    }
}
