package com.xmcc.wx_sell.exception;

import com.xmcc.wx_sell.common.ResultEnums;

/**
 * @author khaleesi
 * @create 2019-06-23 20:21
 */
public class CustomException extends RuntimeException {

    private int code;

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        this(message, ResultEnums.FAIL.getCode());
    }

    public CustomException(String message, int code) {
        super(message);
        this.code = code;
    }
}
