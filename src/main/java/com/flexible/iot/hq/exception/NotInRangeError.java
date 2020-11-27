package com.flexible.iot.hq.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
public class NotInRangeError extends RuntimeException {
    public NotInRangeError(String message) {
        super(message);
    }

    public NotInRangeError(String message, Throwable cause) {
        super(message, cause);
    }
}
