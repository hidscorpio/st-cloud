package com.st.core.exception.checked;

import com.st.core.exception.BaseCheckedException;
import com.st.core.exception.BaseErrorMessage;

/**
 * RemoteClientException
 *
 * @author 枫竹
 * @version V1.0.0
 * @Title: RemoteClientException
 * @Package com.st.core.exception.checked
 * @date 2018/11/9 15:04
 */
public class RemoteClientException extends BaseCheckedException {
    private static final long serialVersionUID = 1L;

    private Integer httpStatus;

    public RemoteClientException(BaseErrorMessage errorMessage, Integer httpStatus) {
        super(errorMessage);
        this.httpStatus = httpStatus;
    }

    public RemoteClientException(BaseErrorMessage errorMessage, Integer httpStatus, Throwable throwable) {
        super(errorMessage, throwable);
        this.httpStatus = httpStatus;
    }

    public RemoteClientException(int code, String message, Integer httpStatus) {
        super(code, message);
        this.httpStatus = httpStatus;
    }

    public RemoteClientException(int code, String message, Integer httpStatus, Throwable throwable) {
        super(code, message, throwable);
        this.httpStatus = httpStatus;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

}
