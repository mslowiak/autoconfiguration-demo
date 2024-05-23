package error.handler;

import error.api.BusinessException;
import error.configuration.ErrorHandlerConfiguration;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public abstract class BusinessExceptionHandler {

    private final ErrorHandlerConfiguration errorConfiguration;

    public BusinessExceptionHandler(ErrorHandlerConfiguration errorConfiguration) {
        this.errorConfiguration = errorConfiguration;
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleException(BusinessException exception) {
        return ResponseEntity
                .status(errorConfiguration.httpCode())
                .headers(headers -> headers.add(errorConfiguration.headerName(), exception.getErrorCode()))
                .body(ErrorResponse.builder(exception, HttpStatusCode.valueOf(errorConfiguration.httpCode()), exception.getErrorCode()).build());
    }

}
