package com.keenness.auth.controller;

import com.keenness.auth.param.UserParam;
import com.keenness.auth.service.AuthService;
import com.keenness.common.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JWT认证
 * @author cj
 * @create 2018-01-18 14:32
 **/
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/token",method = RequestMethod.GET)
    public ResponseEntity<?> createAuthToken(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String token = authService.login("","");
        CookieUtil.createCookie(response,"JWT-TOKEN",token,false,-1);
        return ResponseEntity.ok("认证成功");
    }
}
