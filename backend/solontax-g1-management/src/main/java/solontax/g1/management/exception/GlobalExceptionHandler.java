package solontax.g1.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<CommonExceptionDto> handleException(CommonException exception) {
        CommonExceptionDto exceptionDto =
                CommonExceptionDto.builder()
                                  .status(exception.getStatus())
                                  .message(exception.getMessage())
                                  .build();
        return new ResponseEntity<>(exceptionDto, exception.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonExceptionDto> handleUnexpectedException(Exception exception) {
        CommonExceptionDto exceptionDto =
                CommonExceptionDto.builder()
                                  .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                  .message("An unexpected error occurred: " + exception.getMessage())
                                  .build();
        return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CommonExceptionDto> handleIllegalArgument(IllegalArgumentException exception) {
        CommonExceptionDto exceptionDto =
                CommonExceptionDto.builder()
                                  .status(HttpStatus.BAD_REQUEST)
                                  .message(exception.getMessage())
                                  .build();
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}
