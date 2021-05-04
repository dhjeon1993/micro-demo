package jeon.donghoon.micro.util.http;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class HttpErrorInfo {

    private final LocalDateTime timestamp;
    private final String path;
    private final int status;
    private final String error;
    private final String message;

    public HttpErrorInfo() {
        this.timestamp = null;
        this.status = 999;
        this.path = null;
        this.message = null;
        this.error = null;
    }

    public HttpErrorInfo(HttpStatus httpStatus, String path, String message) {
        timestamp = LocalDateTime.now();
        this.path = path;
        this.status = httpStatus.value();
        this.error = httpStatus.getReasonPhrase();
        this.message = message;
    }

}
