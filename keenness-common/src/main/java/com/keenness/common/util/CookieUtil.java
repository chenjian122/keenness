package com.keenness.common.util;

import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie工具类
 * @author cj
 * @create 2018-01-19 9:21
 **/
public class CookieUtil {

    /**
     * 创建Cookie
     * @param httpServletResponse
     * @param name      cookie 名称
     * @param value     cookie 值
     * @param secure    cookie 安全性
     * @param maxAge    cookie 生命期
     */
    public static void createCookie(HttpServletResponse httpServletResponse,String name ,String value,boolean secure,int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setHttpOnly(false);      //不能被JavaScript获取到，比如document.cookie
        cookie.setSecure(secure);        //true：只能用https协议发送给服务器，用http协议是不发送的
        cookie.setMaxAge(maxAge);        //过期时间设置  -1:会话级cookie，关闭浏览器失效
        cookie.setPath("/");            // cookie所在目录
        httpServletResponse.addCookie(cookie);
    }

    /**
     * 清除Cookie
     * @param httpServletResponse
     * @param name
     */
    public static void clear(HttpServletResponse httpServletResponse,String name){
        Cookie cookie = new Cookie(name,null);
        cookie.setMaxAge(0);                    //不记录cookie
        httpServletResponse.addCookie(cookie);
    }

    /**
     * 获取Cookie
     * @param httpServletRequest
     * @param name
     * @return
     */
    public static String getCookie(HttpServletRequest httpServletRequest,String name){
        Cookie cookie = WebUtils.getCookie(httpServletRequest,name);
        return cookie != null ? cookie.getValue() : null;
    }
}
