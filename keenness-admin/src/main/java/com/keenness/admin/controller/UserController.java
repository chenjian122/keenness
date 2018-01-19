package com.keenness.admin.controller;

import com.keenness.common.util.CookieUtil;
import com.keenness.common.util.ResponseVo;
import com.keenness.common.util.ResponseVoUtil;
import com.keenness.common.util.jwt.JWTHelper;
import com.keenness.common.util.jwt.JWTInfo;
import com.keenness.common.vo.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author cj
 * @create 2018-01-19 11:37
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/validate")
    public UserInfo validate(String userName, String password){
        UserInfo userInfo = new UserInfo();
        userInfo.setId("1");
        userInfo.setNickName("我是有一只有理想的Code");
        userInfo.setPassword("123456");
        userInfo.setUserName("sinspark");
        return userInfo;
    }

    @RequestMapping("/test")
    public ResponseVo page(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        JWTInfo info = JWTHelper.parseJWTInfo(token);
        return ResponseVoUtil.successMsg("成功");
    }
}
