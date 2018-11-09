package com.st.core.exception;

import java.util.Objects;

/**
 * BaseCheckedException
 * 检查异常类
 *
 * @author 枫竹
 * @version V1.0.0
 * @Title: BaseCheckedException
 * @Package com.st.core.exception
 * @date 2018/11/9 15:02
 */
public class BaseCheckedException extends Exception {
    private static final long serialVersionUID = 1L;

    private int code;
    private String message;
    private BaseErrorMessage errorMessage;

    public BaseCheckedException(BaseErrorMessage errorMessage) {
        if (Objects.nonNull(errorMessage)) {
            this.errorMessage = errorMessage;
            this.code = errorMessage.getCode();
            this.message = errorMessage.getMessage();
        }
    }

    public BaseCheckedException(BaseErrorMessage errorMessage, Throwable throwable) {
        super(throwable);
        if (Objects.nonNull(errorMessage)) {
            this.errorMessage = errorMessage;
            this.code = errorMessage.getCode();
            this.message = errorMessage.getMessage();
        }
    }

    public BaseCheckedException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseCheckedException(int code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public BaseErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
