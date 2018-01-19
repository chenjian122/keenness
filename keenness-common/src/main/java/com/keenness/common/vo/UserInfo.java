package com.keenness.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cj
 * @create 2018-01-19 15:01
 **/
@Data
public class UserInfo implements Serializable {

    private String id;

    private String userName;

    private String password;

    private String nickName;
}
