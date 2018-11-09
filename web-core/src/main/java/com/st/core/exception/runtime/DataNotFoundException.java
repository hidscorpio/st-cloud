package com.st.core.exception.runtime;


import com.st.core.exception.BaseErrorMessage;
import com.st.core.exception.BaseRuntimeException;

/**
 * 数据未找到异常
 *
 * @author 枫竹
 */
public class DataNotFoundException extends BaseRuntimeException {
    private static final long serialVersionUID = 1L;

    public DataNotFoundException(BaseErrorMessage errorMessage) {
        super(errorMessage);
    }

    public DataNotFoundException(BaseErrorMessage errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }

    public DataNotFoundException(int code, String message) {
        super(code, message);
    }

    public DataNotFoundException(int code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}
