package com.keenness.gateway.config;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cj
 * @create 2018-01-18 10:17
 **/
public interface IUserPrincipal {

    String getName(HttpServletRequest request);
}
