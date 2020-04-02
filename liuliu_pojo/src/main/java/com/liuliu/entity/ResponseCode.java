package com.liuliu.entity;

public enum ResponseCode {
    SUCCESS(200, "SUCCESS"),
    REQUESTBAD(400, "BAD REQUEST"),
    NOTFOUND(404, "Not Found"),
    FORBIDDEN(403, "Forbidden"),
    SERVERERROR(500, "Server Internal Error"),
    UNAUTHORIZED(401, "unauthorized"),
    CUSTOMERERROR(700, "Customer Error");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
