package com.keenness.auth.service.impl;

import com.keenness.auth.feign.IUserService;
import com.keenness.auth.service.AuthService;
import com.keenness.auth.util.jwt.JwtTokenUtil;
import com.keenness.common.util.CookieUtil;
import com.keenness.common.util.jwt.JWTInfo;
import com.keenness.common.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cj
 * @create 2018-01-18 14:50
 **/
@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IUserService userService;

    @Override
    public String login(String username, String password) throws Exception {
        UserInfo userInfo = userService.validate(username,password);
        JWTInfo jwtInfo = new JWTInfo(userInfo.getUserName(),userInfo.getId(),userInfo.getNickName());
        String token = jwtTokenUtil.generateToken(jwtInfo);
        return token;
    }
}
