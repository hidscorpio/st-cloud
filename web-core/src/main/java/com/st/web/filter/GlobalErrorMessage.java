package com.st.web.filter;


import com.st.core.exception.BaseErrorMessage;

/**
 *
 * @author 枫竹
 */
public enum GlobalErrorMessage implements BaseErrorMessage {
    ARGUMENT_VALID_ERROR(5003, "参数验证错误"),
    ARGUMENT_BIND_ERROR(5002, "参数绑定错误"),
    ARGUMENT_JSON_ERROR(5001, "参数格式错误"),
    INTERNAL_SERVER_ERROR(5000, "内部服务器错误"),
    //
    ;

    private int code;
    private String message;

    GlobalErrorMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
