package raf.si.maticneknjige.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String message;

    public ResourceNotFoundException(String customMessage) {
        super(customMessage);
        message = customMessage;
    }
}
