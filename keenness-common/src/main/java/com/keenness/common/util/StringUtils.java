package com.keenness.common.util;

/**
 * Created by ace on 2017/9/10.
 */
public class StringUtils extends org.springframework.util.StringUtils{
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }
}
