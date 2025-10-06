package solontax.g1.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
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

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CommonExceptionDto> handleIllegalArgument(IllegalArgumentException exception) {
        CommonExceptionDto exceptionDto =
                CommonExceptionDto.builder()
                                  .status(HttpStatus.BAD_REQUEST)
                                  .message(exception.getMessage())
                                  .build();
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<CommonExceptionDto> handleMissingPathVariableException(MissingPathVariableException exception) {
        CommonExceptionDto exceptionDto =
                CommonExceptionDto.builder()
                                  .status(HttpStatus.BAD_REQUEST)
                                  .message("Required path variable is missing " + exception.getVariableName())
                                  .build();
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<CommonExceptionDto> handleNoHandlerFoundException(NoHandlerFoundException exception) {
        CommonExceptionDto exceptionDto =
                CommonExceptionDto
                        .builder()
                        .status(HttpStatus.NOT_FOUND)
                        .message(
                                exception.getMessage() != null ?
                                        exception.getMessage() :
                                        "No handler found exception")
                        .build();
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonExceptionDto> handleGenericException(Exception exception) {
        CommonExceptionDto exceptionDto =
                CommonExceptionDto.builder()
                                  .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                  .message("An unexpected error occurred: " + exception.getMessage())
                                  .build();
        return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
