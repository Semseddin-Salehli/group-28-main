package az.developia.course.qrup28.exception;

import az.developia.course.qrup28.dto.response.ErrorResponse;
import az.developia.course.qrup28.enums.ExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handling(NotFoundException exception, WebRequest request) {
        log.error("Not found {}", exception.getMessage());
        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .path(request.getContextPath())
                .message(exception.getMessage())
                .errorCode(exception.getCode())
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handling(ConstraintViolationException exception, WebRequest request) {
        log.error("Validation exception {}",exception.getMessage());
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .path(request.getContextPath())
                .message(exception.getMessage())
                .errorCode(ExceptionCode.VALIDATION_EXCEPTION.getCode())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handling(MethodArgumentNotValidException exception, WebRequest request) {
        log.error("Validation exception {}",exception.getMessage());
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .path(request.getContextPath())
                .message(exception.getMessage())
                .errorCode(ExceptionCode.VALIDATION_EXCEPTION.getCode())
                .build();
    }
}
