package com.keenness.auth.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cj
 * @create 2018-01-18 14:37
 **/
@Data
public class UserParam implements Serializable {

    private static final long serialVersionUID = -5111298594954202493L;

    private String username;
    private String password;

    public UserParam(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserParam() {
    }
}
