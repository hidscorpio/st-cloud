package com.st.core.exception.runtime;


import com.st.core.exception.BaseErrorMessage;
import com.st.core.exception.BaseRuntimeException;

/**
 * 禁止访问异常
 *
 * @author YuanSongMing
 */
public class UnauthorizedException extends BaseRuntimeException {
    private static final long serialVersionUID = 1L;

    public UnauthorizedException(BaseErrorMessage errorMessage) {
        super(errorMessage);
    }

    public UnauthorizedException(BaseErrorMessage errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }

    public UnauthorizedException(int code, String message) {
        super(code, message);
    }

    public UnauthorizedException(int code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}