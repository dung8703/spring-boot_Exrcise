package api.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import lombok.Getter;
@Getter
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends RuntimeException{
    private String description;
    public InternalServerException(String description) {
        super(description);
        this.description = description;
    }
}
