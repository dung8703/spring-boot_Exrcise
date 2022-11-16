package api.main.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException{
    private String description;
    public ForbiddenException(String description) {
        super(description);
        this.description = description;
    }
}