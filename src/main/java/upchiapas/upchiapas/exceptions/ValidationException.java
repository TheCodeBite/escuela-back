package upchiapas.upchiapas.exceptions;

import lombok.Data;

@Data
public class ValidationException extends RuntimeException {
    private final int errorCode;

    public ValidationException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }


}
