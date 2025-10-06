package solontax.g1.management.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CommonException extends Exception {
    private final HttpStatus status;

    private final String message;

    @Builder
    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.message = message;
    }
}
