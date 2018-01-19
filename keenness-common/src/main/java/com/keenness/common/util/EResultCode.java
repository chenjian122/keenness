package com.keenness.common.util;

/**
 * 统一返回码
 */
public enum EResultCode {
    SUCCESS(200,"操作成功"),
    FAIL(0,"操作失败");
    private int key;
    private String value;
    EResultCode(int key, String value){
        this.key = key;
        this.value = value;
    }
    public int getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }

}
