package com.keenness.common.util;

import java.io.Serializable;

/**
 * 返回json格式数据
 */
public class ResponseVo implements Serializable{

    private static final long serialVersionUID = 5601603823099867345L;


    private Integer           code;
    private String            desc;
    private Object            data;

    private ResponseVo() {
    }

    public Integer getCode() {
        return this.code;
    }

    public ResponseVo setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getDesc() {
        return this.desc;
    }

    public ResponseVo setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Object getData() {
        return this.data;
    }

    public ResponseVo setData(Object data) {
        this.data = data;
        return this;
    }

    public static ResponseVo BUILDER() {
        return new ResponseVo();
    }
}
