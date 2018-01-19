package com.keenness.common.util.jwt;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cj
 * @create 2018-01-18 11:14
 **/
@Data
public class JWTInfo implements Serializable {

    private static final long serialVersionUID = -2523554255696500067L;

    private String userName;
    private String userId;
    private String name;

    public JWTInfo(String userName, String userId, String name) {
        this.userName = userName;
        this.userId = userId;
        this.name = name;
    }

}

