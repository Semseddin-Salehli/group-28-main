package az.developia.course.qrup28.exception;

import az.developia.course.qrup28.dto.response.ErrorResponse;
import az.developia.course.qrup28.enums.ExceptionCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handling(StudentNotFoundException exception , WebRequest request) {
        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .path(request.getContextPath())
                .message(exception.getMessage())
                .errorCode(ExceptionCode.STUDENT_NOT_FOUND_EXCEPTION.getCode())
                .build();
    }
}
