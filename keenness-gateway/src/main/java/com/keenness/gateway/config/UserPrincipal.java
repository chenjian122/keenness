package com.keenness.gateway.config;

import com.keenness.common.util.jwt.JWTHelper;
import com.keenness.common.util.jwt.JWTInfo;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户校验
 * @author cj
 * @create 2018-01-18 10:16
 **/
public class UserPrincipal implements IUserPrincipal{

    @Override
    public String getName(HttpServletRequest request) {
        //jwt token校验
        JWTInfo authToken = getJwtInfo(request);
        return authToken == null ? null : authToken.getUserName();
    }

    private JWTInfo getJwtInfo(HttpServletRequest request){
        JWTInfo authToken = null;
        try{
            String token = request.getHeader("Authorization");
            if(!StringUtils.isEmpty(token)){
                authToken = getInfoFromToken(token);
            }
        }catch (Exception e){
            authToken = null;
        }
        return authToken;
    }

    private JWTInfo getInfoFromToken(String toke){
        return JWTHelper.parseJWTInfo(toke);
    }
}
