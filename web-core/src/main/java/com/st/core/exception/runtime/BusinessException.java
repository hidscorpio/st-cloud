package com.st.core.exception.runtime;

import com.st.core.exception.BaseErrorMessage;
import com.st.core.exception.BaseRuntimeException;

/**
 * 业务异常
 *
 * @author YuanSongMing
 */
public class BusinessException extends BaseRuntimeException {
    private static final long serialVersionUID = 1L;

    public BusinessException(BaseErrorMessage errorMessage) {
        super(errorMessage);
    }

    public BusinessException(BaseErrorMessage errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }

    public BusinessException(int code, String message) {
        super(code, message);
    }

    public BusinessException(int code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}
