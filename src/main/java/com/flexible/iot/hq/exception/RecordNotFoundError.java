package com.flexible.iot.hq.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundError extends RuntimeException {
    public RecordNotFoundError(String message) {
        super(message);
    }

    public RecordNotFoundError(String message, Throwable cause) {
        super(message, cause);
    }
}
