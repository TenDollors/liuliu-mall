package com.liuliu.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// API接口的响应结果封装 响应结果都是json格式
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseData<T> implements Serializable {
    // 请求结果的消息描述
    private String message;
    // 请求的状态码
    private int status;
    // 响应数据
    private Map<String, T> data = new HashMap<>();

    public ResponseData() {

    }

    public ResponseData(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, T> getData() {
        return data;
    }

    public ResponseData putDataValue(String key, T value) {
        data.put(key, value);
        return this;
    }

    public static<T> ResponseData<T> success() {
        return new ResponseData(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDesc());
    }
    public static<T> ResponseData<T> badRequest() {
        return new ResponseData(ResponseCode.REQUESTBAD.getCode(), ResponseCode.REQUESTBAD.getDesc());
    }
    public static<T> ResponseData<T> notFound() {
        return new ResponseData(ResponseCode.NOTFOUND.getCode(), ResponseCode.NOTFOUND.getDesc());
    }
    public static<T> ResponseData<T> forbidden() {
        return new ResponseData(ResponseCode.FORBIDDEN.getCode(), ResponseCode.FORBIDDEN.getDesc());
    }
    public static<T> ResponseData<T> unAuthorized() {
        return new ResponseData(ResponseCode.UNAUTHORIZED.getCode(), ResponseCode.UNAUTHORIZED.getDesc());
    }
    public static<T> ResponseData<T> serverInternalError() {
        return new ResponseData(ResponseCode.SERVERERROR.getCode(), ResponseCode.SERVERERROR.getDesc());
    }
    public static<T> ResponseData<T> customerError() {
        return new ResponseData(ResponseCode.CUSTOMERERROR.getCode(), ResponseCode.CUSTOMERERROR.getDesc());
    }
}
