package com.keenness.auth.service;

/**
 * @author cj
 * @create 2018-01-18 14:50
 **/
public interface AuthService {
    String login(String username, String password) throws Exception;
}
